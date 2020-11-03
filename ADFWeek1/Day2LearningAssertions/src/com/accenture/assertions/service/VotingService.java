package com.accenture.assertions.service;

import com.accenture.assertions.model.Voter;

public class VotingService {
	
	public void castYourVote(Voter voter){
		
		assert voter.getAge()>=18:"Age should be >=18";
		voter.setVote(true);
	}

}
