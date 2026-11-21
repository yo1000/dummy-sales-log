package com.yo1000.saleslog.application;

import com.yo1000.saleslog.config.CustomersExecutorServiceManager;
import com.yo1000.saleslog.config.MemberConfigurationProperties;
import com.yo1000.saleslog.config.ThreadConfigurationProperties;
import com.yo1000.saleslog.config.UnknownExecutorServiceManager;
import com.yo1000.saleslog.domain.*;
import com.yo1000.saleslog.util.ExecutorServiceManager;
import com.yo1000.saleslog.util.TimeCompression;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataAccessException;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class SalesApplicationService {
    private final ExecutorServiceManager customersExecutorServiceManager;
    private final ExecutorServiceManager unknownExecutorServiceManager;
    private final TimeCompression timeCompression;
    private final SecureRandom secureRandom;
    private final SalesDomainService salesDomainService;
    private final PointHolderRepository pointHolderRepository;
    private final KafkaOperations<String, Sales> kafkaOperations;

    private final ThreadConfigurationProperties threadProperties;
    private final MemberConfigurationProperties memberProperties;
    private final VisitSchedule visitSchedule;

    /** 定期来店をどの時点まで処理したか（圧縮後の時刻） */
    private LocalDateTime scheduledVisitsProcessedUntil;

    public SalesApplicationService(
            @CustomersExecutorServiceManager
            ExecutorServiceManager customersExecutorServiceManager,
            @UnknownExecutorServiceManager
            ExecutorServiceManager unknownExecutorServiceManager,
            TimeCompression timeCompression,
            SalesDomainService salesDomainService,
            PointHolderRepository pointHolderRepository,
            KafkaOperations<String, Sales> kafkaOperations,
            ThreadConfigurationProperties threadProperties,
            MemberConfigurationProperties memberProperties,
            VisitSchedule visitSchedule
    ) {
        this.customersExecutorServiceManager = customersExecutorServiceManager;
        this.unknownExecutorServiceManager = unknownExecutorServiceManager;
        this.timeCompression = timeCompression;
        this.secureRandom = new SecureRandom();
        this.salesDomainService = salesDomainService;
        this.pointHolderRepository = pointHolderRepository;
        this.kafkaOperations = kafkaOperations;
        this.threadProperties = threadProperties;
        this.memberProperties = memberProperties;
        this.visitSchedule = visitSchedule;
        this.scheduledVisitsProcessedUntil = timeCompression.now();
    }

    /**
     * 会員によるランダムな来店。1〜maxId の範囲から来店頻度に関係なくランダムに選んだ会員が購入する。
     * {@link VisitFrequency#IRREGULAR} の会員は、この来店でのみ購入する。
     */
    public void sell() {
        for (int i = 0; i < memberProperties.getPurchasesPerSec(); i++) {
            int customerId = secureRandom.nextInt(memberProperties.getMaxId()) + 1;

            customersExecutorServiceManager.submitByKey(customerId, () -> {
                pause();
                purchase(customerId, timeCompression.now());
            });
        }
    }

    /**
     * 定期的に再訪する会員の来店。前回の呼び出しから現在（圧縮後の時刻）までに予定されている来店を、
     * 予定日時で購入させる。{@link VisitFrequency#MONTHLY} は各暦月に1回、{@link VisitFrequency#YEARLY} は各暦年に1回来店する。
     */
    public synchronized void visitScheduled() {
        LocalDateTime from = scheduledVisitsProcessedUntil;
        LocalDateTime to = timeCompression.now();
        List<VisitSchedule.Visit> visits = visitSchedule.visitsBetween(from, to);
        scheduledVisitsProcessedUntil = to;

        for (VisitSchedule.Visit visit : visits) {
            customersExecutorServiceManager.submitByKey(visit.customerId(), () ->
                    purchase(visit.customerId(), visit.dateTime()));
        }
    }

    /**
     * 会員IDから算出される購買パターン・ポイント行使パターンに従って購入し、トピックに投入する。
     */
    private void purchase(int customerId, LocalDateTime dateTime) {
        Customer customer = new Customer(customerId);
        Sales sales = salesDomainService.sell(customer, BuyingPattern.forCustomer(customerId), dateTime);
        PointHolder pointHolder;

        try {
            pointHolder = pointHolderRepository.findByCustomerId(customerId);
        } catch (DataAccessException e) {
            pointHolder = null;
        }

        if (pointHolder == null) {
            pointHolder = new PointHolder(customer, 0);
        }

        sales = pointHolder.usePoint(sales, PointBehaviorPattern.forCustomer(customerId).behavior());
        pointHolderRepository.save(pointHolder);

        kafkaOperations.sendDefault(sales);
    }

    /**
     * 非会員による購入（customer = null）。購買パターンは購入ごとにランダムに抽選され、ポイントは使用しない。
     */
    public void noise() {
        for (int i = 0; i < threadProperties.getNoisesPerSec(); i++) {
            unknownExecutorServiceManager.submit(() -> kafkaOperations.sendDefault(
                    salesDomainService.sell(
                            null,
                            BuyingPattern.random(secureRandom),
                            timeCompression.now())
            ));
        }
    }

    private void pause() {
        try {
            Thread.sleep(secureRandom.nextLong(1000));
        } catch (InterruptedException e) {
            // NOP
            // throw new RuntimeException(e);
        }
    }
}
