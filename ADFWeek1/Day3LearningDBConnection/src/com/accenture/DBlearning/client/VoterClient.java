package com.accenture.DBlearning.client;

import java.util.Scanner;

import com.accenture.DBlearning.model.Voter;
import com.accenture.DBlearning.service.VoterServiceFacade;
import com.accenture.DBlearning.service.VoterServiceIMPL;

public class VoterClient {
	
	public static Scanner sc= new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		VoterServiceFacade service = new VoterServiceIMPL();
		int id,age,minAge,maxAge;
		String name;
		/*System.out.println("Enter Voter");
		System.out.print("ID");
		id=sc.nextInt();
		System.out.print("Name");
		name=sc.next();
		System.out.print("Age");
		age=sc.nextInt();
		if(service.addVoter(new Voter(id, name, age))==1){
			System.out.println("Voter Inserted Successfully");
		} else {
			System.out.println("Error In inserting voter");
		}*/
		System.out.println("All Eligible Voters");
		System.out.println("Enter Min Age");
		minAge=sc.nextInt();
		System.out.println("Enter Max Age");
		maxAge=sc.nextInt();
		System.out.println(service.getAllEligibleVoters(minAge,maxAge));
	}

}
