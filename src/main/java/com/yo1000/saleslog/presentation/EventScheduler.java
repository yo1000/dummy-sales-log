package com.yo1000.saleslog.presentation;

import com.yo1000.saleslog.application.SalesApplicationService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@EnableScheduling
public class EventScheduler {
    private final SalesApplicationService salesApplicationService;

    public EventScheduler(SalesApplicationService salesApplicationService) {
        this.salesApplicationService = salesApplicationService;
    }

    @Scheduled(
            fixedRate = 5,
            initialDelay = 0,
            timeUnit = TimeUnit.SECONDS)
    public void raise() {
        salesApplicationService.sell();
    }
}
