package com.lion.aspect;


import org.aspectj.lang.annotation.After;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by 殷鑫 on 2017/1/14.
 */
@Component
@Aspect
public class LogAspect {
    private static final Logger logger =  LoggerFactory.getLogger(LogAspect.class);
    @Before("execution(* com.lion.controller.IndexController.*(..))")
    public void beforeMethod()
    {
        logger.info("before");
    }
    @After("execution(* com.lion.controller.IndexController.*(..))")
    public void afterMethod()
    {
        logger.info("after");
    }
}
