package com.accenture.DBlearning.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accenture.DBlearning.model.Voter;

public class LearningDBConnectionClient {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			System.out.println("Connected to DB");
			
			Statement stmt = conn.createStatement();									
			
			String query = "select * from voter";
			
			ResultSet res = stmt.executeQuery(query);
			
			List<Voter> voterList = new ArrayList<>();
			
			
			
			while(res.next()){
/*				System.out.println(res.getInt(1) + "\t");
				System.out.print(res.getString(2) + "\t");
				System.out.print(res.getInt(3) + "\t");
				System.out.print(res.getBoolean(4));*/
				
				System.out.print(res.getInt("voterid") + "\t");
				System.out.print(res.getString("votername") + "\t");
				System.out.print(res.getInt("age") + "\t");
				System.out.println(res.getBoolean("vote"));
				
				voterList.add(new Voter(res.getInt(1), res.getString(2), res.getInt(3), res.getBoolean(4)));
				
			}
			
			System.out.println(voterList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
