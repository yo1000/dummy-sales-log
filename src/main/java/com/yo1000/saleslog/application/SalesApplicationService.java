package com.yo1000.saleslog.application;

import com.yo1000.saleslog.domain.*;
import com.yo1000.saleslog.util.ExecutorServiceManager;
import com.yo1000.saleslog.util.TimeCompression;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;

@Service
public class SalesApplicationService {
    private final ExecutorServiceManager executorServiceManager;
    private final TimeCompression timeCompression;
    private final SecureRandom secureRandom;
    private final SalesDomainService salesDomainService;
    private final PointHolderRepository pointHolderRepository;
    private final KafkaOperations<String, Sales> kafkaOperations;

    public SalesApplicationService(
            ExecutorServiceManager executorServiceManager,
            TimeCompression timeCompression,
            SalesDomainService salesDomainService,
            PointHolderRepository pointHolderRepository,
            KafkaOperations<String, Sales> kafkaOperations
    ) {
        this.executorServiceManager = executorServiceManager;
        this.timeCompression = timeCompression;
        this.secureRandom = new SecureRandom();
        this.salesDomainService = salesDomainService;
        this.pointHolderRepository = pointHolderRepository;
        this.kafkaOperations = kafkaOperations;
    }

    public void sell() {
        for (int i = 0; i < Customers.values().length; i++) {
            if (draw()) {
                final int index = i;
                executorServiceManager.submit(i, () -> {
                    pause();
                    Customers customer = Customers.values()[index];
                    LocalDateTime now = timeCompression.now();

                    Sales sales = salesDomainService.sell(customer, now);
                    PointHolder pointHolder = pointHolderRepository.findByCustomerId(sales.customer().id());
                    sales = pointHolder.usePoint(sales, customer.getPointBehavior());
                    pointHolderRepository.save(pointHolder);

                    kafkaOperations.sendDefault(sales);
                });
            }
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
