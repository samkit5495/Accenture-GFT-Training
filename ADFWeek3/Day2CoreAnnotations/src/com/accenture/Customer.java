
package com.accenture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Customer {
	private String name;
	private int id;
//	@Autowired
	@Qualifier("a")
	private Account account;
	public String getName() {
		return name;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	@Autowired
	public Customer(String name, int id, Account account) {
		super();
		this.name = name;
		this.id = id;
		this.account = account;
	}
	
	@Override
	public String toString() {
		return "Customer [name=" + name + ", id=" + id + ", account=" + account + "]";
	}
	
}
