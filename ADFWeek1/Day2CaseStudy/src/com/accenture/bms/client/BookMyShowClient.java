package com.accenture.bms.client;

import java.util.Scanner;

import com.accenture.bms.dao.MovieDAO;
import com.accenture.bms.model.Movie;

public class BookMyShowClient {

	public static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovieDAO movieDAO = new MovieDAO();
		int choice;
		int movieId;
		String movieName;
		int seatsAvailable;
		Movie movie = null;
		do{
			System.out.println("0. Exit");
			System.out.println("1. Populate the list with a movies");
			System.out.println("2. Delete a movie based on the movie id");
			System.out.println("3. Retrieve all the movies");
			System.out.println("4. Search a movie on movie name");
			System.out.println("5. Sort the movies on seats available");
			System.out.println("Select your choice");
			choice=sc.nextInt();
			switch(choice){
			case 1:
				System.out.println("Add Movie");
				System.out.println("Enter Movie Name:");
				movieName = sc.next();
				System.out.println("Enter Seats Available");
				seatsAvailable = sc.nextInt();
				movieDAO.addMovie(new Movie(movieName, seatsAvailable));
				System.out.println("Movie Added");
				break;
			case 2:
				System.out.println(movieDAO.showAllMovie());
				System.out.println("Delete Movie");
				System.out.println("Enter Movie ID:");
				movieId=sc.nextInt();
				movie = movieDAO.searchMovie(movieId);
				if(movieDAO.deleteMovie(movie)){
					System.out.println("Movie Deleted Successfully");
				} else {
					System.out.println("Movie Not Found");
				}
				break;
			case 3:
				System.out.println("All Movie");
				System.out.println(movieDAO.showAllMovie());
				break;
			case 4:
				System.out.println("Search Movie");
				System.out.println("Enter Movie Name:");
				movieName = sc.next();
				System.out.println("Search Result:");
				System.out.println(movieDAO.searchMovie(movieName));
				break;
			case 5:
				System.out.println("Sorted Movie");
				System.out.println(movieDAO.sortOnSeatsAvailable());
				break;
			default:
				System.out.println("Invalid Choice");	
			}
		} while(choice!=0);
	}

}
