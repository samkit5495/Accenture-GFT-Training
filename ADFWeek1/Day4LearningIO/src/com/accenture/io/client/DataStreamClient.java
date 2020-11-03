package com.accenture.io.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class DataStreamClient {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream is=null;
		DataInputStream dis=null;
		FileOutputStream fos=null;
		DataOutputStream dos=null;
		double[] buff={56.5641,56.35,564.485,564.1,354.54};
		fos=new FileOutputStream("test.txt");
		
		dos=new DataOutputStream(fos);
		
		for(double d:buff){
			dos.writeDouble(d);
		}
		dos.flush();
		
		dos.close();
		dos.close();
		
		is=new FileInputStream("test.txt");
		dis=new DataInputStream(is);
		
		while(dis.available()>0){
			System.out.println(dis.readDouble());
		}
		
	}

}
