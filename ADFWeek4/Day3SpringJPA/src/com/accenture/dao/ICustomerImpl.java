package com.accenture.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


import com.accenture.entity.Customer;

public class ICustomerImpl implements ICustomer {

	private EntityManagerFactory factory;
	private EntityManager manager;
	private EntityTransaction transaction;
	private Query q;
	
	
	
	public EntityManagerFactory getFactory() {
		return factory;
	}

	public void setFactory(EntityManagerFactory factory) {
		this.factory = factory;
	}

	@Override
	public Customer getById(int id) {
		// TODO Auto-generated method stub
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		transaction.begin();
		q = manager.createQuery("from Customer where id=?");
		q.setParameter(1, id);
		transaction.commit();
		return (Customer) q.getSingleResult();
	}

	@Override
	public List<Customer> getByCity(String city) {
		// TODO Auto-generated method stub
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		transaction.begin();
		q = manager.createQuery("from Customer where city=?");
		q.setParameter(1, city);
		transaction.commit();
		return q.getResultList();
	}

}
