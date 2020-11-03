package com.accenture.io.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleIO {

	public static void main(String[] args) throws IOException {
		System.out.println("Enter a string:");
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));  
		String line;
		while((line=in.readLine())!=null && (line.length()!=0)){
			System.out.println("You entered:"+line);
		}
	}
}
