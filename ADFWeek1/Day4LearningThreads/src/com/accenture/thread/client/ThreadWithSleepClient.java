package com.accenture.thread.client;

class Counter extends Thread{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1;i<=5;i++)
		{
			try {
				System.out.println("Running " + this.getName());
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}
}

public class ThreadWithSleepClient {

	public static void main(String[] args) {

		Thread t1 = new Counter();
		t1.setName("T1");
		Thread t2=new Counter();
		t2.setName("T2");
		
		t1.start();
		t2.start();

	}

}
