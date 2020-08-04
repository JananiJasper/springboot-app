package com.movieapp.moviecatalog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.movieapp.moviecatalog.model.MovieCatalog;
import com.movieapp.moviecatalog.model.MovieInfo;
import com.movieapp.moviecatalog.model.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MovieInfoService {
	
	@Autowired
	private RestTemplate restTemplate;	
	
	@HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
	public MovieCatalog getCatalogItem(Rating rating) {
		MovieInfo movie = restTemplate.getForObject("http://movie-info-service/movieInfo/"+rating.getMovieId(),MovieInfo.class);
		return new MovieCatalog(movie.getMovieId(),movie.getName(),movie.getDescription(),rating.getRating());
	}
	
	public MovieCatalog getFallbackCatalogItem(Rating rating){
		return new MovieCatalog(0,"Movie Name not found","",rating.getRating());
	}

}
