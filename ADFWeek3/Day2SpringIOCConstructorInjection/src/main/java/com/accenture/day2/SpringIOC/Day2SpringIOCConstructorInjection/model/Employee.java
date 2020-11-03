package com.accenture.day2.SpringIOC.Day2SpringIOCConstructorInjection.model;

public class Employee {
	
	private int id;
	private String name;
	private Address address;
	public Employee(int id, String name, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

	
	
	

}
