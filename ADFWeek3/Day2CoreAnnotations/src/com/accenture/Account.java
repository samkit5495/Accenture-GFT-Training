
package com.accenture;

public class Account {
	
	private int id;
	private double balance;
	public int getId() {
		return id;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Account(int id, double balance) {
		super();
		this.id = id;
		this.balance = balance;
	}
	
	
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + "]";
	}
	
	

}
