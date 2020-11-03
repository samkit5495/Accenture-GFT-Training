package com.accenture.day2.springIOC.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accenture.day2.springIOC.model.Employee;

public class Client {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("emp.xml");
		
		Employee e = (Employee) context.getBean("e");
			System.out.println(e.getId());
			System.out.println(e.getName());
			System.out.println(e.getAddress().getCity());
			System.out.println(e.getAddress().getPincode());
	}
}	