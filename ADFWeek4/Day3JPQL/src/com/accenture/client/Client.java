package com.accenture.client;

import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.accenture.entity.Product;

public class Client {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Day3JPQL");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();

		Product p1 = new Product(1, "MI Redmi Note 3", 10000);
		manager.persist(p1);
		Product p2 = new Product(2, "MI Redmi Note 4", 12000);
		manager.persist(p2);
		Product p3 = new Product(3, "MI Redmi Note 5", 14000);
		manager.persist(p3);
		
		Query query = manager.createQuery("from Product");
		List<Product> plist = query.getResultList();
		System.out.println(plist);
		
		Query query1 = manager.createQuery("select productName from Product");
		List<String> pNamelist = query1.getResultList();
		System.out.println(pNamelist);
		
		Query query2 = manager.createQuery("select productName, productPrice from Product");
		List<Object[]> pNamePricelist = query2.getResultList();
		for (Object[] i :pNamePricelist)
			System.out.println(i[0]+"\t"+i[1]);
		
		Query query3 = manager.createQuery("update Product set productPrice=? where productId=?");
		query3.setParameter(1, 9999.0f);
		query3.setParameter(2, 1);
		System.out.println(query3.executeUpdate());
		Product p = manager.find(Product.class, 1);
		manager.refresh(p);
		System.out.println(p);
		
		Query query4 = manager.createNamedQuery("getAllProducts");
		List<Product> pNamedQuerylist = query4.getResultList();
		System.out.println(pNamedQuerylist);
		
		Query query5 = manager.createNativeQuery("select * from Products",Product.class);
		List<Product> pNativelist = query5.getResultList();
		System.out.println(pNativelist);
		
		transaction.commit();
	}

}
