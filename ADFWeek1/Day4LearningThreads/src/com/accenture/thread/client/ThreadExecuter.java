package com.accenture.thread.client;

public class ThreadExecuter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccountService service = new AccountService();
		service.start();
	}

}
