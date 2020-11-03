package com.accenture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.dao.EmployeeDAO;
import com.accenture.model.Employee;

@Component("employeeIMPL")
public class IEmployeeServiceImpl implements IEmployeeService {

	@Autowired
	@Qualifier("employeeDAO")
	EmployeeDAO dao;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public void saveEmployees(List<Employee> empList) {
		for(Employee e:empList){
			dao.insertEmployee(e);
		}
	}

}
