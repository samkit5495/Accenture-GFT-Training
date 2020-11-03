package com.accenture.unittesting.dao;

public class CalculatorDAO {

	public int addition(int num1, int num2){
		if(num1<0 || num2<0)
//			throw new IllegalArgumentException("INVALID DATA: Negative values not allowed!");
			throw new IllegalArgumentException();
		if(num1>100 || num2>100)
//			throw new IllegalArgumentException("INVALID DATA: Values out of range!");
			throw new IllegalArgumentException();
		return num1+num2;
	}
}
