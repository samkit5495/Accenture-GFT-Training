package com.accenture.day5.casestudy.service;

import java.util.List;

import com.accenture.day5.casestudy.model.Voter;

public interface VoterServiceFacade {

	public int addVoter(Voter voter);
	
	public Voter searchVoter(int voterId);
	
	public boolean vote(Voter voter);
	
	public List<Voter> getAllEligibleVoters(int minAge, int maxAge);
}
