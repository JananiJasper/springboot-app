package com.movieapp.moviecatalog.model;

public class MovieInfo {

	private long movieId;
	private String name;
	private String description;
	
	public MovieInfo() {
		super();
	}
	
	public MovieInfo(long movieId, String name, String description) {
		super();
		this.movieId = movieId;
		this.name = name;
		this.description=description;
	}
	public long getMovieId() {
		return movieId;
	}
	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
