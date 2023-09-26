package com.ravi.watchlist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.watchlist.entity.Movie;
import com.ravi.watchlist.repository.MovieRepo;

@Service
public class DatabaseService {
	
	@Autowired
	MovieRepo movieRepo;
	
	@Autowired
	RatingServices ratingService;
	
	// save method for data base;
	public void create(Movie movie) {
		
		String rating = ratingService.getMovieRating(movie.getTitle());
		if(rating != null) {
			movie.setRating(Float.parseFloat(rating));
		}
		movieRepo.save(movie);
	}   
	
	public List<Movie> getAllMovies(){
		return movieRepo.findAll();
	}
	
	public Movie getMovieById(Integer id) {
		return movieRepo.findById(id).get();
	}
	
   public void update(Movie movie , Integer id) {
	   Movie tobeUpdated = getMovieById(id);
	   tobeUpdated.setTitle(movie.getTitle());
	   tobeUpdated.setRating(movie.getRating());
	   tobeUpdated.setPriority(movie.getPriority());
	   tobeUpdated.setComment(movie.getComment());
	   
	   movieRepo.save(tobeUpdated);
	      
   }
   
   public void delete( Integer id) {
	
	   movieRepo.deleteById(id); 
	   
   }
}
