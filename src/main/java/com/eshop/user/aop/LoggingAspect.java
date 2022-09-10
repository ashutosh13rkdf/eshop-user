package com.eshop.user.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.List;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger LOGGER = LogManager.getLogger(LoggingAspect.class);
    @Pointcut(value= "execution(* com.eshop.user..*(..))")
    private void logDisplayingBalance()
    {
    }
//    @Around(value= "logDisplayingBalance()")
//    public void aroundAdvice(ProceedingJoinPoint jp) throws Throwable
//    {
//        System.out.println("The method aroundAdvice() before invokation of the method " + jp.getSignature().getName() + " method");
//        try
//        {
//            jp.proceed();
//        }
//        finally
//        {
//
//        }
//        System.out.println("The method aroundAdvice() after invokation of the method " + jp.getSignature().getName() + " method");
//    }
}