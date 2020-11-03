package com.accenture.unittesting.test;

import com.accenture.unittesting.service.CalculatorServiceImpl;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorDAOTest {

	static CalculatorServiceImpl service;
	@BeforeClass
	public static void setUp(){
		System.out.println("Called before each test");
		service = new CalculatorServiceImpl();
	}
	
	@AfterClass
	public static void tearDown(){
		System.out.println("Called after each test");
		service = null;
	}
	
	@Test
	public void testAddition(){
		int num1=10;
		int num2=20;
		
		int expectedResult = 30;
		
		int actualResult = this.service.addition(num1, num2);
		
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testAdditionNegative(){
		int num1=-10;
		int num2=20;
		
		String exceptedException = "INVALID DATA: Negative values not allowed!";
		
		try{
			this.service.addition(num1, num2);
		} catch(IllegalArgumentException e){
			assertTrue(e.getMessage(),true);
		}
	}
}
