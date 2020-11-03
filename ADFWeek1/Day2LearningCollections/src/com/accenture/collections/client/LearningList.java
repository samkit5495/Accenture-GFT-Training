package com.accenture.collections.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LearningList {

	public static void main(String[] args) {
		List<String> names = new LinkedList<>();

		names.add("samkit");
		names.add("aish");
		names.add("abha");
		names.add("abha");
		
		System.out.println(names);

		System.out.println(names.get(0));
		
		for(int i=0;i<names.size();i++){
			System.out.print(names.get(i)+"\t");
		}
		System.out.println();
		names.remove(2);
		
		for(String s:names){
			System.out.print(s+"\t");
		}
		System.out.println();
		Collections.reverse(names);
		System.out.println("Reverse: "+names);
		
		
		
		List<Integer> prices = new ArrayList<>();

		prices.add(10);
		prices.add(40);
		prices.add(45);
		prices.add(34);
		
//		for(int i=0;i<prices.size();i++){
//			System.out.println(prices.remove(i));
//			System.out.println(prices);
//		}
		
//		for(Integer i:prices){
//			System.out.println(prices.remove(i));
//			System.out.println(prices);
//		}
//		
//		Iterator<Integer> itr = prices.iterator();
//		while (itr.hasNext()) {
//			System.out.println(prices.remove(itr.next()));
//			System.out.println(prices);
//		}
		Collections.sort(prices);
		

		
	}
}
