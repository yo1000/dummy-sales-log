package com.yo1000.saleslog.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.LocalDate;

@ConfigurationProperties(prefix = "app.time-compression")
public record TimeCompressionProperties(
        LocalDate initialDate
) {}
