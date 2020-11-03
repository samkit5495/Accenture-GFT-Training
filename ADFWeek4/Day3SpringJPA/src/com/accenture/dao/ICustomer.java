package com.accenture.dao;

import java.util.List;

import com.accenture.entity.Customer;

public interface ICustomer {

	public Customer getById(int id);
	
	public List<Customer> getByCity(String city);
	
}
