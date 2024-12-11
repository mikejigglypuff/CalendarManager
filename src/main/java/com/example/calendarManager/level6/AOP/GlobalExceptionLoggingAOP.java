package com.example.calendarManager.level6.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
@Order(1)
// 전역에서 발생한 예외 로깅 담당
public class GlobalExceptionLoggingAOP {
    @AfterThrowing(
        pointcut = "execution(* com.example.calendarManager..*(..))",
        throwing = "e"
    )
    public void logException(JoinPoint joinPoint, Exception e) {
         log.error("Exception in {}.{} with arguments {} - {}",
            joinPoint.getSignature().getDeclaringTypeName(),
            joinPoint.getSignature().getName(),
            joinPoint.getArgs(),
            e.getMessage(),
            e);
    }
}
