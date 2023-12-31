package com.ravi.watchlist.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.ravi.watchlist.entity.Movie;
import com.ravi.watchlist.service.DatabaseService;

import jakarta.validation.Valid;

@RestController
public class MovieController {
	
	@Autowired	
	DatabaseService databaseService ;

	@GetMapping("/watchlistItemForm")
	public ModelAndView showWatchListForm(@RequestParam(required = false) Integer id) {
		  System.out.println(id);
		String viewName="watchlistitemForm";
		Map<String, Object> model = new HashMap<>();
		/* Movie dummyMovie = new Movie();
		dummyMovie.setTitle("Ravan");
		dummyMovie.setPriority(0);
		dummyMovie.setRating(0);
		dummyMovie.setComment("srk movie");  
		model.put("watchlistItem", dummyMovie);
		*/
		if(id==null) {
			model.put("watchlistItem", new Movie());
		}else {
			model.put("watchlistItem",databaseService.getMovieById(id));
		}
		
		return new ModelAndView(viewName,model);  
	}
	   
	  @PostMapping("/watchlistItemForm")
	public ModelAndView submitWatchlistForm(@Valid @ModelAttribute("watchlistItemForm")Movie movie, BindingResult bindingResult){
		
		  if(bindingResult.hasErrors()) {
			  return new ModelAndView("watchlistItemForm");
		  }
		  /*  
		  if( id == null) {
		  create new Movie	  
		  }
		  else{
		  update
		  }
		  */
		  Integer id = movie.getId();
		  //create new Movie
		  if(id==null) {
			  databaseService.create(movie);
		  }else { // Update Movie
			  databaseService.update(movie, id);
		  }
	   RedirectView rd = new RedirectView();
	   rd.setUrl("/watchlist");
	   return new ModelAndView(rd);    		
	}
	  
	  
	  @GetMapping("/watchlist")
	  public ModelAndView getWatchlist() {
		  
		  String viewName="watchlist";
		  Map<String,Object> model = new HashMap<>();
		  List<Movie> movieList = databaseService.getAllMovies();
		  model.put("noofmovies", movieList.size());
		  model.put("watchlistrows",databaseService.getAllMovies());	
		  return new ModelAndView(viewName,model);
		    
	  }
	  
	  @GetMapping("/deletMovie")
	    public ModelAndView deleteMovie(@RequestParam Integer id ) {
	        // Check if the movie with the given ID exists in the database
	        Movie existingMovie = databaseService.getMovieById(id);

	        if (existingMovie != null) {
	            // If the movie exists, delete it
	            databaseService.delete( id);
	        }

	        
	        // Redirect to the watchlist page after deletion
	        RedirectView rd = new RedirectView();
	        rd.setUrl("/watchlist");
	        return new ModelAndView(rd);
	    }
	  
	  
	  
	
	  
	  
}
