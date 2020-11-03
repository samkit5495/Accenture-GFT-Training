package com.accenture.learningweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.accenture.learningweb.model.User;
import com.accenture.learningweb.utility.DBConnection;

public class LoginServiceDAO {

	public boolean validateUser(User user) {
		// TODO Auto-generated method stub
		Connection conn=DBConnection.getConnection();
		String query = "select count(*) from user where username=? and password=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				if(rs.getInt(1)>=1){
					return true;
				}
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
