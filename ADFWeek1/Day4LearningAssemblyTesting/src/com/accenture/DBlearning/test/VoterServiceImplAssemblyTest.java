package com.accenture.DBlearning.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.accenture.DBlearning.dao.VoterDAO;
import com.accenture.DBlearning.model.Voter;
import com.accenture.DBlearning.service.VoterServiceIMPL;

import static org.junit.Assert.*;

public class VoterServiceImplAssemblyTest {

	static VoterServiceIMPL service;
	static VoterDAO dao;
	@BeforeClass
	public static void setUp(){
		service = new VoterServiceIMPL();
		dao = new VoterDAO();
	}
	
	@AfterClass
	public static void tearDown(){
		service = null;
		dao = null;
	}
	
	@Ignore
	public void addVoterTest(){
		Voter v = new Voter(78, "sj", 18);
		service.addVoter(v);
		assertEquals(dao.searchVoter(v.getVoterId()).getVoterId(),v.getVoterId());
	}
	
	@Test
	public void getAllEligibleVotersTest(){
		int minAge=20;
		int maxAge=25;
		assertEquals(service.getAllEligibleVoters(minAge, maxAge).size(), dao.getAllEligibleVoters(minAge, maxAge).size());
	}
	
	
}
