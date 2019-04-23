package com.proj.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {
	@Pointcut("execution(* com.proj.controller.*.*(..))")
	public void controllerLayerExecution() {
	}

	@Pointcut("execution(* com.proj.persistence.DAO.*.*(..))")
	public void DAOExecution() {
	}
}
