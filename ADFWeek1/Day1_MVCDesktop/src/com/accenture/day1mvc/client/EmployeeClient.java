package com.accenture.day1mvc.client;

import java.io.IOException;
import java.util.Scanner;

import com.accenture.day1mvc.dao.EmployeeDAO;
import com.accenture.day1mvc.model.Employee;
import com.accenture.day1mvc.service.EmployeeServiceFacade;

public class EmployeeClient {

	public static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Create an Employee");
		Employee e = new Employee();
		System.out.println("Enter Employee Id:");
		e.setEmpId(sc.nextInt());
		System.out.println("Enter Employee Name:");
		e.setEmpName(sc.next());
		System.out.println("Enter Employee Monthly Salary:");
		e.setEmpSal(sc.nextDouble());
		
		EmployeeServiceFacade service = new EmployeeDAO();
		if(service.createEmployee(e)){
			System.out.println(e + "Employee Created Successfully");
		} else {
			System.out.println("Error creating: " + e);
		}
		
		System.out.println(service.calculateAnnualSalary(e));
		System.out.println(e);
	}

}
