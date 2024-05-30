package com.yo1000.saleslog.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yo1000.saleslog.domain.Customers;
import com.yo1000.saleslog.domain.Sales;
import com.yo1000.saleslog.domain.SalesDomainService;
import com.yo1000.saleslog.util.ExecutorServiceManager;
import com.yo1000.saleslog.util.TimeCompression;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class SalesApplicationService {
    private final ExecutorServiceManager executorServiceManager;
    private final TimeCompression timeCompression;
    private final SecureRandom secureRandom;
    private final SalesDomainService salesDomainService;
    private final KafkaOperations<String, Sales> kafkaOperations;
    private final ObjectMapper objectMapper;

    public SalesApplicationService(
            ExecutorServiceManager executorServiceManager,
            TimeCompression timeCompression,
            SalesDomainService salesDomainService,
            KafkaOperations<String, Sales> kafkaOperations,
            ObjectMapper objectMapper
    ) {
        this.executorServiceManager = executorServiceManager;
        this.timeCompression = timeCompression;
        this.secureRandom = new SecureRandom();
        this.salesDomainService = salesDomainService;
        this.kafkaOperations = kafkaOperations;
        this.objectMapper = objectMapper;
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
