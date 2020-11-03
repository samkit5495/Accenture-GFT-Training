package com.accenture.exceptionhandling.client;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


class Test{
	
	public static Connection getConnection(String s) throws SQLException{
		return null;
	}
	
}


public class CheckedExceptionClient {
	
	public static void x() throws IOException{
		try {
			throw new IOException("try");
		} finally {
			throw new IOException("finally");
		}
	}

	public static void main(String[] args){
		// TODO Auto-generated method stub
		/*try {
			Test.getConnection("asd");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		
		try {
			x();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
