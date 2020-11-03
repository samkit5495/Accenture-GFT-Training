package com.accenture.thread.client;

class FaxThread implements Runnable{
	
	@Override
	public void run() {
		System.out.println("Sending your fax document");
		System.out.println("Please collect your document");
	}
	
}

public class LearningMultiThreadWithRunnable {

	public static void main(String[] args) {

		System.out.println("Current/Main thread:" + Thread.currentThread());
		System.out.println("Current thread name:" + Thread.currentThread().getName());
		
		Thread resume=new Thread(new FaxThread(), "FAXTHREAD");
		
		resume.start();

	}

}
