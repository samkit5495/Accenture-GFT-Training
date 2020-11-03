package com.accenture;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("student.xml");
		Student s = ((Student)context.getBean("student"));
		Date d = ((Date)context.getBean("date"));
		s.setRollNo(7);
//		s.setName("samkit");
		s.setBirthDate(d);
		d.setDay(5);
		d.setMonth(4);
		d.setYear(1995);
		System.out.println(s);
	}

}
