package com.accenture.unittesting.test;

import com.accenture.unittesting.dao.CalculatorDAO;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class CalculatorServiceIMPLTest {

	static CalculatorDAO dao;
	@BeforeClass
	public static void setUp(){
		System.out.println("Called before each test");
		dao = new CalculatorDAO();
	}
	
	@AfterClass
	public static void tearDown(){
		System.out.println("Called after each test");
		dao = null;
	}
	
	@Test
	public void testAddition(){
		int num1=10;
		int num2=20;
		
		int expectedResult = 30;
		
		int actualResult = this.dao.addition(num1, num2);
		
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testAdditionNegative(){
		int num1=-10;
		int num2=20;
		
		String exceptedException = "INVALID DATA: Negative values not allowed!";
		
		try{
			this.dao.addition(num1, num2);
		} catch(IllegalArgumentException e){
			assertEquals(e.getMessage(),null);
		}
	}
}
