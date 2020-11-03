package com.accenture.collections.client;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import com.accenture.assertions.model.Voter;

public class LearningTreeSetImplementation {

	public static void main(String[] args) {
		
		Set<String> names = new TreeSet<>();
		
		names.add("samkit");
		names.add("aish");
		names.add("abha");
		

		System.out.println(names);

		Set<Integer> numbers = new TreeSet<>();
		
		numbers.add(5);
		numbers.add(-5);
		numbers.add(0);
		

		System.out.println(numbers);
		
		Set<Voter> pdc4 = new TreeSet<>();
		pdc4.add(new Voter("black", "samkit", 22));
		pdc4.add(new Voter("black", "abha", 22));
		pdc4.add(new Voter("black", "vaibhav", 23));
		
		Iterator<Voter> itr=pdc4.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}
}
