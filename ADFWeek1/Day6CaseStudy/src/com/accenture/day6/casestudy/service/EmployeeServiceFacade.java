package com.accenture.day6.casestudy.service;

import java.util.List;

import com.accenture.day6.casestudy.model.Employee;

public interface EmployeeServiceFacade {

	public List<Employee> searchEmployee(int dept);
}
