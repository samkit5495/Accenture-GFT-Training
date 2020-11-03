package com.accenture.bms.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.accenture.bms.model.Movie;
import com.accenture.bms.service.MovieServiceFacade;

public class MovieDAO implements MovieServiceFacade {

	private ArrayList<Movie> movieList = new ArrayList<>();
	
	@Override
	public void addMovie(Movie movie) {
		// TODO Auto-generated method stub
		this.movieList.add(movie);
	}

	@Override
	public boolean deleteMovie(Movie movie) {
		// TODO Auto-generated method stub
		return this.movieList.remove(movie);
	}

	@Override
	public List<Movie> showAllMovie() {
		// TODO Auto-generated method stub
		return movieList;
	}

	@Override
	public List<Movie> searchMovie(String name) {
		// TODO Auto-generated method stub
		List<Movie> result=new ArrayList<>();
		for(Movie m:this.movieList){
			if(m.getMovieName().indexOf(name)!=-1){
				result.add(m);
			}
		}
		return result;
	}
	
	public Movie searchMovie(int id) {
		// TODO Auto-generated method stub
		for(Movie m:this.movieList){
			if(m.getMovieId()==id){
				return m;
			}
		}
		return null;
	}

	@Override
	public List<Movie> sortOnSeatsAvailable() {
		// TODO Auto-generated method stub
		/*
		//Object o=new Movie("hello",45);
		Object o=new Object();
		
		//Movie m=new Object();
		
		Movie m=(Movie)o;*/
		
		Object o=movieList.clone();
		
		ArrayList<Movie> movies =(ArrayList<Movie>)o;
		Collections.sort(movies);
		/*Collections.sort(movieList, new Comparator<Movie>() {

			@Override
			public int compare(Movie o1, Movie o2) {
				// TODO Auto-generated method stub
				return o1.getMovieName().compareTo(o2.getMovieName());
			}
			
		});*/
		return movies;
	}

}
