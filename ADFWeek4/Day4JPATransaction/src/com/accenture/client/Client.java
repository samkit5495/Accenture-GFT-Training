package com.accenture.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accenture.model.Employee;
import com.accenture.service.IEmployeeService;

public class Client {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		IEmployeeService service =  (IEmployeeService) context.getBean("employeeIMPL");
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(1, "samkit", "jain"));
		empList.add(new Employee(2, "abha", "kamble"));
		service.saveEmployees(empList);
	}
}
