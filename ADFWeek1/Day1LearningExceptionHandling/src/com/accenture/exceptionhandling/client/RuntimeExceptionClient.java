package com.accenture.exceptionhandling.client;

public class RuntimeExceptionClient {

	public static void main(String[] args) {
		
		int arr[]= new int[]{0,2,3};
		
		try{
			System.out.println(arr[1]);
			System.out.println(arr[3]);
//			System.out.println(arr[-2]);
//			System.out.println(arr[1]/arr[0]);
//			int demo[]=new int[-4];
		} 
		catch (Exception re){
			System.out.println(re.getClass());
		}
		finally{
			int demo[]=new int[-4];
			System.out.println("I am always executed");
		}
		/*catch (ArithmeticException re){
			System.out.println(re.getClass());
		} catch (ArrayIndexOutOfBoundsException re){
			System.out.println(re.getClass());
		} catch (RuntimeException re){
			System.out.println(re.getClass());
		} catch (Exception re){
			System.out.println(re.getClass());
		}*/
		System.out.println("Program execution continues...");
	}
}
