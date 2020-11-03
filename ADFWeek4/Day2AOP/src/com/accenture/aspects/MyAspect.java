package com.accenture.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {

	@Before("execution(public void com.accenture.model.Customer.setId(int))")	
	public void logging(){
		System.out.println("Method called");
	}
	
	@Before("execution(* com.accenture.model.Customer.*(..))")	
	public void logging1(){
		System.out.println("before all methods Method called");
	}
	
	@Before("execution(* com.accenture.model.*.get*(..))")	
	public void logging2(){
		System.out.println("before all getter methods Method called");
	}
	
	@Before("execution(* *.*(..))")	
	public void logging3(){
		System.out.println("allllll");
	}
	
	@Before("logging4()")
	public void logging5(){
		System.out.println("pointcut");
	}
	
	@Pointcut("execution(public void com.accenture.model.Customer.setId(int))")
	public void logging4(){
	}
	
	
}
