package com.accenture.DBlearning.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accenture.DBlearning.model.Voter;
import com.accenture.DBlearning.utility.DBConnection;

public class VoterDAO {

	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	
	public int addVoter(Voter voter) {
		// TODO Auto-generated method stub
		int rowCount=0;
		try {
			conn = DBConnection.getConnection();
			String sql = "insert into voter values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, voter.getVoterId());
			pstmt.setString(2, voter.getVoterName());
			pstmt.setInt(3, voter.getVoterAge());
			pstmt.setBoolean(4, voter.isVote());
			rowCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	public List<Voter> getAllEligibleVoters(int minAge, int maxAge) {
		// TODO Auto-generated method stub
		List<Voter> voterList = new ArrayList<>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from voter where vote=true and age between ? and ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, minAge);
			pstmt.setInt(2, maxAge);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				voterList.add(new Voter(rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getBoolean(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return voterList;
	
	}
}