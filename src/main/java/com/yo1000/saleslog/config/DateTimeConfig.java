package com.yo1000.saleslog.config;

import com.yo1000.saleslog.util.TimeCompression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DateTimeConfig {
    @Bean
    public TimeCompression timeCompression() {
        return new TimeCompression();
    }
}
