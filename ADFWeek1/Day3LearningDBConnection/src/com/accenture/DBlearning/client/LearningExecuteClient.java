package com.accenture.DBlearning.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accenture.DBlearning.model.Voter;

public class LearningExecuteClient {

	public static void main(String[] args) {
		
		Connection conn=null;
		Statement stmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			System.out.println("Connected to DB");
			
			stmt = conn.createStatement();									
			
//			String query = "insert into voter values(106,'Samkit',22,false)";
			String query = "select votername, age from voter where vote=true";
			
			boolean result = stmt.execute(query);
			
			if(result){
				System.out.println("DQL statement is executed");
				ResultSet rs=stmt.getResultSet();
				System.out.println("List of good citizens of india");
				while(rs.next()){
					System.out.println(rs.getString("votername")+"\t"+rs.getInt("age"));
				}
			}else{
				System.out.println("DML statement is executed");
				int rowCount = stmt.getUpdateCount();
				System.out.println("No of voter inserted:" + rowCount);
			}
			
			
			
			
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
