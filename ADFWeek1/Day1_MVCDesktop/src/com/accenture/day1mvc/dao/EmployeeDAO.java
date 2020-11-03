package com.accenture.day1mvc.dao;

import java.io.IOException;

import com.accenture.day1mvc.exception.EmployeeException;
import com.accenture.day1mvc.model.Employee;
import com.accenture.day1mvc.service.EmployeeServiceFacade;

public class EmployeeDAO implements EmployeeServiceFacade {

	@Override
	public boolean createEmployee(Employee emp) {
		// TODO Auto-generated method stub
		if(emp.getEmpId()<=0)
		{
			throw new EmployeeException("Emp ID cannot be <=0");
		}
		else if (emp.getEmpName().trim().length()==0){
			throw new EmployeeException("Emp Name cannot be empty!");
		}
		return true;
	}

	@Override
	public double calculateAnnualSalary(Employee emp) {
		// TODO Auto-generated method stub
		emp.setTotalSal(FISCAL_YEAR_MONTH_COUNT * emp.getEmpSal());
		return emp.getTotalSal();
	}

	
}
