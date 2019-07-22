package com.bridgelab.aop;

import org.junit.Before;

@Aspect
	public class EmployeeCRUDAspect<JoinPoint> 
	{
	      
	    @Before("execution(* EmployeeManager.getEmployeeById(..))")         //point-cut expression
	    public void logBeforeV1(JoinPoint joinPoint)
	    {
	        System.out.println("EmployeeCRUDAspect.logBeforeV1() : " + joinPoint.getSignature().getName());
	    }
	}

