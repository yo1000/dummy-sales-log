package com.yo1000.saleslog.config;

import com.yo1000.saleslog.util.ExecutorServiceManager;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ThreadConfigurationProperties.class)
public class ThreadConfig {
    @Bean
    @CustomersExecutorServiceManager
    public ExecutorServiceManager customersExecutorServiceManager() {
        return new ExecutorServiceManager(6);
    }

    @Bean
    @UnknownExecutorServiceManager
    public ExecutorServiceManager unknownExecutorServiceManager(ThreadConfigurationProperties threadProperties) {
        return new ExecutorServiceManager(Math.min(threadProperties.getNoisesPerSec(), 2_000));
    }
}
