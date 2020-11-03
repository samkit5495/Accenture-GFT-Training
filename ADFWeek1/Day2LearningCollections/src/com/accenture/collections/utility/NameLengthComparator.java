package com.accenture.collections.utility;

import java.util.Comparator;

import com.accenture.assertions.model.Voter;

public class NameLengthComparator implements Comparator<Voter>{

	@Override
	public int compare(Voter o1, Voter o2) {
		// TODO Auto-generated method stub
		return Integer.valueOf(o1.getVoterName().length()).compareTo(Integer.valueOf(o2.getVoterName().length()));
	}

}
