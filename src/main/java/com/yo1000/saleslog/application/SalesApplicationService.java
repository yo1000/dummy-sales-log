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
            MemberConfigurationProperties memberProperties
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
    }

    /**
     * 会員による購入。1〜maxId の範囲からランダムに選んだ会員が、
     * 会員IDから算出される購買パターン・ポイント行使パターンに従って購入する。
     */
    public void sell() {
        for (int i = 0; i < memberProperties.getPurchasesPerSec(); i++) {
            int customerId = secureRandom.nextInt(memberProperties.getMaxId()) + 1;

            customersExecutorServiceManager.submitByKey(customerId, () -> {
                pause();
                LocalDateTime now = timeCompression.now();

                Customer customer = new Customer(customerId);
                Sales sales = salesDomainService.sell(customer, BuyingPattern.forCustomer(customerId), now);
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
            });
        }
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
