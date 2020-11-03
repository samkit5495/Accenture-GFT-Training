package com.accenture.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accenture.model.Customer;


public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
		Customer c = (Customer)context.getBean("customer");
		c.setId(500);	
		c.getId();
	}

}
