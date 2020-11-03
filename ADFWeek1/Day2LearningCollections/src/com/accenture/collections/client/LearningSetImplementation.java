package com.accenture.collections.client;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import com.accenture.assertions.model.Voter;

public class LearningSetImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer a= Integer.valueOf(5);
		Integer b= Integer.valueOf(5);
		
		Set collection1 = new LinkedHashSet<>();
		collection1.add(10);
		collection1.add(20.34);
		collection1.add(new String("Hello"));
		collection1.add(new Integer(55));
		collection1.add(new Voter("black","samkit", 22));
		collection1.add(20.34);
		collection1.add(55);
		collection1.add(10);
		System.out.println(collection1);
		
		//Method 1
		
		for(Object i:collection1){
			System.out.println(i);
		}
		
		//Method 2
		
		Iterator itr=collection1.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
		System.out.println("Before:");
		System.out.println(collection1);
		collection1.remove(55);
		System.out.println("After:");
		System.out.println(collection1);
		
		System.out.println("Size: " + collection1.size());
		
		System.out.println("IsEmpty:" + collection1.isEmpty());
	}

}
