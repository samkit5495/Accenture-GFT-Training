package com.accenture.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.accenture.entity.Book;

public class Client {
	
	public static void main(String[] args) {
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("Day2JPA");
		
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		/*
		Book b=new Book();
		b.setBookName("samkit");
		b.setPrice(5406);
		
		manager.persist(b);
		*/
		Book b1 = manager.find(Book.class, 1);
		System.out.println(b1);
		/*
		b1.setPrice(7000);
		
		manager.merge(b1);*/
		
		manager.remove(b1);
		
		transaction.commit();
	}

}
