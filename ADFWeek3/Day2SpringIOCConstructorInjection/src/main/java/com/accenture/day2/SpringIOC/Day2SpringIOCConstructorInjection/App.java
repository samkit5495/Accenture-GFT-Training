package com.accenture.day2.SpringIOC.Day2SpringIOCConstructorInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accenture.day2.SpringIOC.Day2SpringIOCConstructorInjection.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context = new ClassPathXmlApplicationContext("emp.xml");
	Employee e = (Employee) context.getBean("e");
	System.out.println(e);
    }
}
