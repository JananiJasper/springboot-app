package com.movieapp.movieinfoservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieapp.movieinfoservice.model.MovieInfo;

@RestController
@RequestMapping("/movieInfo")
public class MovieInfoController {
	
	 @GetMapping("/{movieId}")
	 public MovieInfo getMovieById(@PathVariable("movieId")String movieId){ 
		return new MovieInfo(movieId,"test");
	 }

}