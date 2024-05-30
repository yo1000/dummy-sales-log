package com.yo1000.saleslog.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DomainServiceAdvice {
    private final ObjectMapper objectMapper;

    public DomainServiceAdvice(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @AfterReturning(
            value = "execution(* *..domain.*.*(..)) && @target(org.springframework.stereotype.Service)",
            returning = "returnValue")
    public void logReturn(JoinPoint joinPoint, Object returnValue) {
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());

        try {
            logger.debug(objectMapper.writeValueAsString(returnValue));
        } catch (JsonProcessingException e) {
            // NOP
        }
    }
}
