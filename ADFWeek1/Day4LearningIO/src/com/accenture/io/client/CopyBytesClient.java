package com.accenture.io.client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyBytesClient {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream inputStream=null;
		FileOutputStream outputStream=null;

		outputStream=new FileOutputStream("ProductDetailsBytes.txt");
		
		String message="I would be byte stream";
		
		byte data[]=message.getBytes();
		
		outputStream.write(data);
		
		System.out.println("Byte Stream successfully written to file");
		
		outputStream.close();
		
		inputStream = new FileInputStream("ProductDetailsBytes.txt");
		int c;
		while((c=inputStream.read())!=-1){
			System.out.print((char)c);
		}
	}

}
