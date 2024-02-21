package com.aop.query.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@org.aspectj.lang.annotation.Aspect
@Slf4j
@Component
public class Aspect {
    @Pointcut("execution(* com.aop.query.controller.*.*(..))")
    public void loggingPointCut(){
    }

    @Before("loggingPointCut()")
    public void before( JoinPoint joinPoint ){
        log.info("Before method invoked::"+joinPoint.getSignature());
    }
    @After("loggingPointCut()")
    public void after(JoinPoint joinPoint){
        log.info("transction submitted::"+joinPoint.getKind());
    }

    @AfterThrowing("loggingPointCut()")
    public void afterthrow(JoinPoint joinPoint){
        log.info("transction echoued::"+joinPoint.getTarget());
    }

    @Pointcut("execution(* com.aop.query.service.KafkaService.*(..))")
    public void kafkaloggin(){};

    @Before("kafkaloggin()")
    public void beforeConsuming(JoinPoint joinPoint){
        log.info("message consumed::"+joinPoint.getTarget());
    }

}
