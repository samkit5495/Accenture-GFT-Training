package com.accenture.day6.casestudy.service;
import java.util.List;

import com.accenture.day6.casestudy.dao.EmployeeDAO;
import com.accenture.day6.casestudy.model.Employee;
import com.accenture.day6.casestudy.service.EmployeeServiceFacade;

public class EmployeeServiceIMPL implements EmployeeServiceFacade {

	EmployeeDAO dao=new EmployeeDAO();
	@Override
	public List<Employee> searchEmployee(int dept) {
		// TODO Auto-generated method stub
		return dao.searchEmployee(dept);
	}

}
