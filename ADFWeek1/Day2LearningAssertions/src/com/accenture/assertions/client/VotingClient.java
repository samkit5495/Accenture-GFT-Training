package com.accenture.assertions.client;

import java.util.Scanner;

import com.accenture.assertions.model.Voter;
import com.accenture.assertions.service.VotingService;

public class VotingClient {

	public static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		String name;
		int age=0;
		
		System.out.println("Welcome to Gujrat Voting Booth");
		
		Voter voter;
		System.out.println("Enter your Name:");
		name=sc.next();
		System.out.println("Enter your age:");
		age=sc.nextInt();
		
		voter = new Voter(name,age);
		
		VotingService service = new VotingService();
		try{
		service.castYourVote(voter);
		}catch(AssertionError ae){
			System.out.println(ae.getMessage());
		}
		System.out.println(voter);
	}
}
