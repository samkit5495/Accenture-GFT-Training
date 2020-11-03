package com.accenture.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accenture.dao.ICustomer;

public class Client {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("customer.xml");
		ICustomer service = (ICustomer) context.getBean("ICustomerImpl");
		System.out.println(service.getById(1));
		System.out.println(service.getByCity("pune"));
	}
}
