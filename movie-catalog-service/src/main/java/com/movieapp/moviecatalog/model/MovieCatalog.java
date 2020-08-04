package com.movieapp.moviecatalog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MovieCatalog")
public class MovieCatalog {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long movieId;
	
	@Column(name = "name", nullable = false)
    private String name;
	
	@Column(name = "desc", nullable = false)
    private String desc;
	
	@Column(name = "rating", nullable = false)
    private int rating;
	
	public MovieCatalog() {
		super();
	}
	
	public MovieCatalog(long movieId, String name, String desc, int rating) {
		super();
		this.movieId = movieId;
		this.name = name;
		this.desc = desc;
		this.rating = rating;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
}
