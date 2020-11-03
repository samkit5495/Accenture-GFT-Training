package com.accenture.day2.annotations.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accenture.day2.annotations.model.Customer;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("customer.xml");
		System.out.println(((Customer)context.getBean("c")));
	}

}
