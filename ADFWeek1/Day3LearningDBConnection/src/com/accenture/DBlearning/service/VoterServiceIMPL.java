package com.accenture.DBlearning.service;

import java.util.ArrayList;
import java.util.List;

import com.accenture.DBlearning.dao.VoterDAO;
import com.accenture.DBlearning.model.Voter;

public class VoterServiceIMPL implements VoterServiceFacade {


	VoterDAO dao = new VoterDAO(); 
	
	@Override
	public int addVoter(Voter voter) {
		// TODO Auto-generated method stub
		return dao.addVoter(voter);
	}

	@Override
	public List<Voter> getAllEligibleVoters(int minAge, int maxAge) {
		// TODO Auto-generated method stub
		return dao.getAllEligibleVoters(minAge,maxAge);
	}

}
