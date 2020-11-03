package com.accenture.collections.utility;

import java.util.Comparator;

import com.accenture.assertions.model.Voter;

public class AgeComparator implements Comparator<Voter>{

	@Override
	public int compare(Voter o1, Voter o2) {
		// TODO Auto-generated method stub
		return new Integer(o1.getAge()).compareTo(new Integer(o2.getAge()));
	}
	
	

}
