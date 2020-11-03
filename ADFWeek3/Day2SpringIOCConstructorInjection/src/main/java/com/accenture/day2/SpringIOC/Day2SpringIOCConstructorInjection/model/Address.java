package com.accenture.day2.SpringIOC.Day2SpringIOCConstructorInjection.model;

public class Address {

	private int pincode;
	private String city;
	public Address(int pincode, String city) {
		super();
		this.pincode = pincode;
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [pincode=" + pincode + ", city=" + city + "]";
	}
	
	
	
}
