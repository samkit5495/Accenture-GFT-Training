package com.accenture.bms.model;

public class Movie implements Comparable<Movie>{

	private int movieId;
	private String movieName;
	private int seatsAvailable;
	private static int movieCount=0;
	
	public Movie(String movieName, int seatsAvailable) {
		super();
		this.movieId = ++movieCount;
		this.movieName = movieName;
		this.seatsAvailable = seatsAvailable;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		if(movieName.trim().length() == 0)
			throw new IllegalArgumentException("Movie Name cannot be empty.");
		this.movieName = movieName;
	}
	public int getSeatsAvailable() {
		return seatsAvailable;
	}
	public void setSeatsAvailable(int seatsAvailable) {
		if(seatsAvailable<0)
			throw new IllegalArgumentException("Seats Available should be grater than or equal to 0.");
		this.seatsAvailable = seatsAvailable;
	}
	@Override
	public String toString() {
		return "\nMovie [movieId=" + movieId + ", movieName=" + movieName + ", seatsAvailable=" + seatsAvailable + "]\n";
	}
	@Override
	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		if(this.getSeatsAvailable()==o.getSeatsAvailable())
			return 0;
		if(this.getSeatsAvailable()<o.getSeatsAvailable())
			return 1;
		else
			return -1;
	}
}
