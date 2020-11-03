package com.accenture.bms.service;

import java.util.List;


import com.accenture.bms.model.Movie;

public interface MovieServiceFacade {

	public void addMovie(Movie movie);
	
	public boolean deleteMovie(Movie movie);
	
	public List<Movie> showAllMovie();
	
	public List<Movie> searchMovie(String name);
	
	public Movie searchMovie(int id);
	
	public List<Movie> sortOnSeatsAvailable();
	
}
