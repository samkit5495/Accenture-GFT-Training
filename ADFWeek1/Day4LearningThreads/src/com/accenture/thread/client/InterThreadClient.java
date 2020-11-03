package com.accenture.thread.client;

import java.util.Scanner;

class Customer{
	private int amount=10000;
	public synchronized void withdraw(int amt){
		System.out.println("withdraw process started");
		if(amt>amount){
			System.out.println("pls deposit the amount");
			System.out.println("waiting sufficient balance");
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.amount-=amt;
		System.out.println(this);
	}
	
	public synchronized void deposit(int amt){
		System.out.println("Deposit process started");
		this.amount+=amt;
		System.out.println("Deposit complete");
		System.out.println(this);
		notify();
	}

	@Override
	public String toString() {
		return "Customer [amount=" + amount + "]";
	}
	
}

class WithdrawThread extends Thread
{
	Customer cust;
	int amountWithdraw;
	WithdrawThread(Customer cust){
		this.cust=cust;
	}
	
	public void setAmountWithdraw(int amountWithdraw) {
		this.amountWithdraw = amountWithdraw;
	}
	
	@Override
	public void run() {
		this.cust.withdraw(amountWithdraw);
	}
}


class DepositThread extends Thread
{
	Customer cust;
	int amountDeposit;
	DepositThread(Customer cust){
		this.cust=cust;
	}
	
	public void setAmountDeposit(int amountDeposit) {
		this.amountDeposit = amountDeposit;
	}
	
	@Override
	public void run() {
		this.cust.deposit(amountDeposit);
	}
}

public class InterThreadClient {

	public static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) throws InterruptedException {
		Customer cust=new Customer();
		WithdrawThread wt=new WithdrawThread(cust);
		DepositThread dt=new DepositThread(cust);
		System.out.println("Amount to withdraw");
		wt.setAmountWithdraw(sc.nextInt());
		System.out.println("Amount to deposit");
		dt.setAmountDeposit(sc.nextInt());
		wt.start();
		dt.start();
//		wt.join();
//		dt.join();
	}

}
