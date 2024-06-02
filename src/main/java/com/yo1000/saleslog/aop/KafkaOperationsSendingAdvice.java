package com.yo1000.saleslog.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class KafkaOperationsSendingAdvice {
    private final Logger logger = LoggerFactory.getLogger(KafkaOperationsSendingAdvice.class);

    private final ObjectMapper objectMapper;

    public KafkaOperationsSendingAdvice(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @After("execution(* org.springframework.kafka.core.KafkaOperations+.sendDefault(..))")
    public void logReturn(JoinPoint joinPoint) {
        try {
            logger.debug(objectMapper.writeValueAsString(joinPoint.getArgs()));
        } catch (JsonProcessingException e) {
            // NOP
        }
    }
}
