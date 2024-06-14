package com.yo1000.saleslog.config;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Qualifier("UnknownExecutorServiceManager")
public @interface UnknownExecutorServiceManager {}
