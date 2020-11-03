package com.accenture.DBlearning.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accenture.DBlearning.model.Voter;

public class LearningExecuteUpdateClient {

	public static void main(String[] args) {
		
		Connection conn=null;
		Statement stmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			System.out.println("Connected to DB");
			
			stmt = conn.createStatement();									
			
//			String query = "insert into voter values(105,'Samkit',22,false)";
			
			String query = "update voter set vote=true where age>18";
			
			int rowCount = stmt.executeUpdate(query);
			
//			System.out.println("No of rows inserted is "+ rowCount);
			
			System.out.println("No of rows updated is "+ rowCount);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
