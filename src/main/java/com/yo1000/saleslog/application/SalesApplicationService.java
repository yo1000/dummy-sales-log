package com.yo1000.saleslog.application;

import com.yo1000.saleslog.config.CustomersExecutorServiceManager;
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
import java.util.Arrays;

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

    public SalesApplicationService(
            @CustomersExecutorServiceManager
            ExecutorServiceManager customersExecutorServiceManager,
            @UnknownExecutorServiceManager
            ExecutorServiceManager unknownExecutorServiceManager,
            TimeCompression timeCompression,
            SalesDomainService salesDomainService,
            PointHolderRepository pointHolderRepository,
            KafkaOperations<String, Sales> kafkaOperations,
            ThreadConfigurationProperties threadProperties
    ) {
        this.customersExecutorServiceManager = customersExecutorServiceManager;
        this.unknownExecutorServiceManager = unknownExecutorServiceManager;
        this.timeCompression = timeCompression;
        this.secureRandom = new SecureRandom();
        this.salesDomainService = salesDomainService;
        this.pointHolderRepository = pointHolderRepository;
        this.kafkaOperations = kafkaOperations;
        this.threadProperties = threadProperties;
    }

    public void sell() {
        Arrays.stream(Customers.values())
                .filter(customer -> customer.data() != null)
                .filter(_customer -> draw())
                .forEach(customer -> customersExecutorServiceManager.submit(customer, () -> {
                    pause();
                    LocalDateTime now = timeCompression.now();

                    Sales sales = salesDomainService.sell(customer, now);
                    PointHolder pointHolder;

                    try {
                        pointHolder = pointHolderRepository.findByCustomerId(sales.customer().getId());
                    } catch (DataAccessException e) {
                        pointHolder = null;
                    }

                    if (pointHolder == null) {
                        pointHolder = pointHolderRepository.save(new PointHolder(customer.data(), 0));
                    }

                    sales = pointHolder.usePoint(sales, customer.getPointBehavior());
                    pointHolderRepository.save(pointHolder);

                    kafkaOperations.sendDefault(sales);
                }));
    }

    public void noise() {
        for (int i = 0; i < threadProperties.getNoisesPerSec(); i++) {
            unknownExecutorServiceManager.submit(() -> kafkaOperations.sendDefault(
                    salesDomainService.sell(
                            Customers.UNKNOWN,
                            timeCompression.now())
            ));
        }
    }

    private boolean draw() {
        return secureRandom.nextBoolean();
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
