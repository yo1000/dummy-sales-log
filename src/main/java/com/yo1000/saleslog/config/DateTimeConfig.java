package com.yo1000.saleslog.config;

import com.yo1000.saleslog.util.TimeCompression;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(TimeCompressionProperties.class)
public class DateTimeConfig {
    @Bean
    public TimeCompression timeCompression(TimeCompressionProperties props) {
        return new TimeCompression(props.initialDate());
    }
}
