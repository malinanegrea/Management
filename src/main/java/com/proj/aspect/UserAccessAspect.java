package com.proj.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class UserAccessAspect {

	private final static Logger logger = Logger.getLogger(UserAccessAspect.class);

	// What kind of method calls I would intercept
	// execution(* PACKAGE.*.*(..))
	// Weaving & Weaver
	@Before("execution(* com.proj.controller.*.*(..))")
	public void before(JoinPoint joinPoint) {
		// Advice
		logger.info(" Check for user access ");
		logger.info(" Allowed execution for " + joinPoint);
	}

	@Around("execution(*  com.proj.controller.*.*(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.nanoTime();

		Object result = joinPoint.proceed();

		long timeTaken = (System.nanoTime()- startTime)/1000000;
		logger.info("Time Taken by" + joinPoint + "is " + timeTaken + " milliseconds");
		
		return result;
	}
	

	@After(value = "execution(* com.proj.controller.*.*(..))")
	public void after(JoinPoint joinPoint) {
		logger.info("after execution of " + joinPoint);
	}
}