package com.accenture.day1mvc.service;

import java.io.IOException;

import com.accenture.day1mvc.model.Employee;

public interface EmployeeServiceFacade {
	
	int FISCAL_YEAR_MONTH_COUNT=5;
	
	public boolean createEmployee(Employee emp);

	public double calculateAnnualSalary(Employee emp);

}
