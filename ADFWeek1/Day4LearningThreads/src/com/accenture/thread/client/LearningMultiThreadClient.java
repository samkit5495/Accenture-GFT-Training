package com.accenture.thread.client;

class Printer extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(this.getName());
	}
}

public class LearningMultiThreadClient {

	public static void main(String[] args) {
		
		Printer hp=new Printer();
		hp.setName("HP Printer : Print Java Doc");
		hp.start();
		Printer cannon=new Printer();
		cannon.setName("Cannon Printer : Print Oracle Doc");
		cannon.start();
	}
}
