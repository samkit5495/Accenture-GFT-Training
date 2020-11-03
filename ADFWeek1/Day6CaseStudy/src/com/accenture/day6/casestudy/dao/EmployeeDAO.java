package com.accenture.day6.casestudy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accenture.day6.casestudy.model.Employee;
import com.accenture.day6.casestudy.utility.DBConnection;

public class EmployeeDAO {

	public List<Employee> searchEmployee(int dept) {
		// TODO Auto-generated method stub
		Connection conn=DBConnection.getConnection();
		List<Employee> employeeList=new ArrayList<>();
		
		try {
			String query="select * from employee where dept=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, dept);
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()){
				employeeList.add(new Employee(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return employeeList;
	}
}
