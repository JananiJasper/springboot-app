package com.movieapp.moviecatalog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.movieapp.moviecatalog.exception.ResourceNotFoundException;
import com.movieapp.moviecatalog.model.MovieCatalog;
import com.movieapp.moviecatalog.model.UserRating;
import com.movieapp.moviecatalog.repository.MovieCatalogRepository;
import com.movieapp.moviecatalog.services.MovieInfoService;
import com.movieapp.moviecatalog.services.UserRatingInfoService;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
	
	@Autowired
	MovieCatalogRepository catalogRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	MovieInfoService movieInfo;
	
	@Autowired
	UserRatingInfoService userRatingInfo;
	
	@GetMapping("/{userId}")
	public List<MovieCatalog> getCatalog(@PathVariable("userId")String userId)	{
		UserRating userRating = userRatingInfo.getUserRating(userId);
		return userRating.getRatings().stream()
				.map(rating -> movieInfo.getCatalogItem(rating))
				.collect(Collectors.toList());
	}
		
	 @GetMapping("/movieList")
	    public ResponseEntity<List<MovieCatalog>> getAllMovies(){
		        return ResponseEntity.ok(catalogRepo.findAll());
	 }
	
	  @PostMapping("/addMovies")
	    public ResponseEntity<MovieCatalog> createMovie(@RequestBody MovieCatalog movie){
	        return ResponseEntity.ok(catalogRepo.save(movie));
	    }
	  
	  @PutMapping("/updateMovies/{id}")
	    public ResponseEntity <MovieCatalog> updateMovies(@PathVariable(value = "id") Long movieId,
	        @RequestBody MovieCatalog movieDetails) throws ResourceNotFoundException {
		 
		  MovieCatalog movies = catalogRepo.findById(movieId)
	            .orElseThrow(() -> new ResourceNotFoundException("Movie not found for this id :: " + movieId));

		  	movies.setName(movieDetails.getName());
		  	movies.setDesc(movieDetails.getDesc());
		  	movies.setRating(movieDetails.getRating());
	        
	        return ResponseEntity.ok(catalogRepo.save(movies));
	    }

	    @DeleteMapping("/deleteMovies/{id}")
	    public Map < String, Boolean > deleteMovie(@PathVariable(value = "id") Long movieId)
	    throws ResourceNotFoundException {
	    	MovieCatalog deletedMovies = catalogRepo.findById(movieId)
	            .orElseThrow(() -> new ResourceNotFoundException("Movie not found for this id :: " + movieId));
	    	
	        catalogRepo.delete(deletedMovies);	        
	        Map < String, Boolean > response = new HashMap < > ();
	        response.put("Deleted", Boolean.TRUE);
	        return response;
	    } 
}
