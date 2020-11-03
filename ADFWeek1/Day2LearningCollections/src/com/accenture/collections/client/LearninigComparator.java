package com.accenture.collections.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.accenture.assertions.model.Voter;
import com.accenture.collections.utility.AgeComparator;
import com.accenture.collections.utility.NameLengthComparator;

public class LearninigComparator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Voter> voterList = new ArrayList<>();
		voterList.add(new Voter("red", "abha", 22));
		voterList.add(new Voter("black", "samkit", 23));
		Collections.sort(voterList, new AgeComparator());
		System.out.println(voterList);
		Collections.sort(voterList, new NameLengthComparator());
		System.out.println(voterList);
	}

}
