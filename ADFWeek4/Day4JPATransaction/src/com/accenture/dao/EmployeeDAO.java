package com.accenture.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.model.Employee;

@Component
public class EmployeeDAO implements IEmployeeDAO {

	@Autowired
	private JdbcTemplate template;
	
	@Override
	public void insertEmployee(Employee e) {
		// TODO Auto-generated method stub
		String sql = "insert into employee values(?,?,?)";
		template.update(sql,e.getId(),e.getFname(),e.getLname());
		System.out.println(e+" Inserted");
	}

}
