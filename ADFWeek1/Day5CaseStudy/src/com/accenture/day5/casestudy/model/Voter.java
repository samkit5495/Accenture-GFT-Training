package com.accenture.day5.casestudy.model;

public class Voter {
	
	private int voterId;
	private String voterName;
	private int voterAge;
	private boolean vote;
	public Voter(int voterId, String voterName, int voterAge, boolean vote) {
		super();
		this.voterId = voterId;
		this.voterName = voterName;
		this.voterAge = voterAge;
		this.vote = vote;
	}
	public int getVoterId() {
		return voterId;
	}
	public void setVoterId(int voterId) {
		this.voterId = voterId;
	}
	public String getVoterName() {
		return voterName;
	}
	public void setVoterName(String voterName) {
		this.voterName = voterName;
	}
	public int getVoterAge() {
		return voterAge;
	}
	public void setVoterAge(int voterAge) {
		this.voterAge = voterAge;
	}
	public boolean isVote() {
		return vote;
	}
	public void setVote(boolean vote) {
		this.vote = vote;
	}
	public Voter(int voterId, String voterName, int voterAge) {
		super();
		this.voterId = voterId;
		this.voterName = voterName;
		this.voterAge = voterAge;
	}
	@Override
	public String toString() {
		return "\nVoter [voterId=" + voterId + ", voterName=" + voterName + ", voterAge=" + voterAge + ", vote=" + vote
				+ "]";
	}
	
	

}
