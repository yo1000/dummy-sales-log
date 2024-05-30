package com.yo1000.saleslog.config;

import com.yo1000.saleslog.util.ExecutorServiceManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThreadConfig {
    @Bean
    public ExecutorServiceManager executorServiceManager() {
        return new ExecutorServiceManager(6);
    }
}
