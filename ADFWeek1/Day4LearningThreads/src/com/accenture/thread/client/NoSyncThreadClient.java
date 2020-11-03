
package com.accenture.thread.client;

class  TableService{
	
	/*public synchronized void printTable(int num){
		for(int i=1;i<=10;i++){
			System.out.println(num + " x " + i + " = " + num*i);
		}
	}*/
	
	public void printTable(int num){
		synchronized (this){
			for(int i=1;i<=10;i++){
				System.out.println(num + " x " + i + " = " + num*i);	
			}
		}
	}
}

class TableThread extends Thread{
	private int num;
	TableService service;
	public TableThread(TableService service,int num) {
		this.num=num;
		this.service=service;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		service.printTable(num);
	}
}

public class NoSyncThreadClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TableService ts=new TableService();
		new TableThread(ts,7).start();
		new TableThread(ts,5).start();
	}

}
