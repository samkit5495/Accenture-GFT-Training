package com.accenture.day5.casestudy.service;

import java.util.List;

import com.accenture.day5.casestudy.dao.VoterDAO;
import com.accenture.day5.casestudy.model.Voter;

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

	@Override
	public Voter searchVoter(int voterId) {
		// TODO Auto-generated method stub
		return dao.searchVoter(voterId);
	}

	@Override
	public boolean vote(Voter voter) {
		// TODO Auto-generated method stub
		return dao.vote(voter);
	}

}
