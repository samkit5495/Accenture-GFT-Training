package com.accenture;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
		Customer c = (Customer)context.getBean("newCustomer");
		System.out.println(c);
	}

}
