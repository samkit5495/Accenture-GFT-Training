package com.accenture.io.client;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharactersClient {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileReader inputStream=null;
		FileWriter outputStream=null;
		
		try {
			outputStream=new FileWriter("ProductDetails.txt");
			outputStream.write("Hello World");					
			System.out.println("Content written to file");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(outputStream!=null)
				outputStream.close();
		}
		
		inputStream=new FileReader("ProductDetails.txt");
		int c;
		while((c=inputStream.read())!=-1){
			System.out.print((char)c);
		}
	}

}
