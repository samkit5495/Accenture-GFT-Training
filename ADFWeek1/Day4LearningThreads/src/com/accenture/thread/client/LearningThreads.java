package com.accenture.thread.client;

public class LearningThreads {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		
		Thread.currentThread().start();
	}
}
