package com.accenture.client;

import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.accenture.entity.College;
import com.accenture.entity.Student;

public class Client {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Day2JPQL");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		Student s1=new Student();
		s1.setRollNo(1);
		s1.setName("samkit");
		s1.setAddress("pune");
		manager.persist(s1);
		
		Student s2=new Student();
		s2.setRollNo(2);
		s2.setName("abha");
		s2.setAddress("nagpur");
		manager.persist(s2);
		
		Student s3=new Student();
		s3.setRollNo(3);
		s3.setName("vaibhav");
		s3.setAddress("indapur");
		manager.persist(s3);
		
		HashSet<Student> sinhgadStudents = new HashSet<>();
		sinhgadStudents.add(s1);
		sinhgadStudents.add(s2);
		
		HashSet<Student> mitStudents = new HashSet<>();
		mitStudents.add(s3);
		
		College sinhgad = new College();
		sinhgad.setId(1);
		sinhgad.setName("Sinhgad");
		sinhgad.setStudents(sinhgadStudents);
		manager.persist(sinhgad);
		
		College mit = new College();
		mit.setId(2);
		mit.setName("MIT");
		mit.setStudents(mitStudents);
		manager.persist(mit);
		
		College c = manager.find(College.class, 1);
		manager.remove(c);
		
		transaction.commit();
	}

}
