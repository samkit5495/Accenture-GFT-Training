package com.accenture.assertions.model;

public class Voter extends Person /*implements Comparable<Voter>*/{

	private String voterName;
	private int age;
	private boolean vote;
	
	public String getVoterName() {
		return voterName;
	}
	public void setVoterName(String voterName) {
		this.voterName = voterName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Voter [voterName=" + voterName + ", age=" + age + ", vote=" + vote + ", getHairColor()="
				+ getHairColor() + "]";
	}
	
	
	public Voter(String hairColor, String voterName, int age) {
		super(hairColor);
		this.voterName = voterName;
		this.age = age;
	}
	public boolean isVote() {
		return vote;
	}
	public void setVote(boolean vote) {
		this.vote = vote;
	}
	/*@Override
	public int compareTo(Voter o) {
		// TODO Auto-generated method stub
		return new Integer(this.getAge()).compareTo(new Integer(o.getAge()));
	}*/
	
	
}
