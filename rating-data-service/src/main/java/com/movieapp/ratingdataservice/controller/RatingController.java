package com.movieapp.ratingdataservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieapp.ratingdataservice.model.Rating;
import com.movieapp.ratingdataservice.model.UserRating;

@RestController
@RequestMapping("/ratingInfo")
public class RatingController {

	@GetMapping("/{movieId}")
	 public Rating getRating(@PathVariable("movieId")String movieId){ 
		return new Rating(movieId,2);
		 // return ResponseEntity.ok(catalogRepo.getOne(userId)); }Arrays.asList(new Rating("111",2),new Rating("222",4));
	 }
	@GetMapping("/users/{userId}")
	 public UserRating getUserRating(@PathVariable("userId")String userId){ 		
		UserRating userRating = new UserRating();
		userRating.initData(userId);
		
		return userRating;
	}
}
