package com.accenture.DBlearning.service;

import java.util.List;

import com.accenture.DBlearning.model.Voter;

public interface VoterServiceFacade {

	public int addVoter(Voter voter);
	
	public Voter searchVoter(int voterId);
	
	public List<Voter> getAllEligibleVoters(int minAge, int maxAge);
}
