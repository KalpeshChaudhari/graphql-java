/* ***************************************************************************
 * Copyright 2018 Mindstix, Inc.  All rights reserved.
 * -- Mindstix Confidential
 * ***************************************************************************/

package com.elc.learn;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RestControllerAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestControllerAspect.class);

    @Before("execution(public * com.elc.learn.controller.*Controller.*(..))")
    public void logBeforeRestCall(JoinPoint pjp) throws Throwable {
        LOGGER.info(":::::AOP Before REST call:::::" + pjp);
    }
}
