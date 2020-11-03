package com.accenture.io.client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable {

	int id;
	String name;
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	
	
}

public class SerializeDeserializeClient {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Student s=new Student(1, "samkit");
		
		FileOutputStream fout=new FileOutputStream("stud.txt");
		ObjectOutputStream out=new ObjectOutputStream(fout);
		
		out.writeObject(s);
		out.flush();
		System.out.println("Success");
		
		out.close();
		fout.close();
		
		FileInputStream fin = new FileInputStream("stud.txt");
		ObjectInputStream in = new ObjectInputStream(fin);
		
		System.out.println((Student)in.readObject());
	}

}
