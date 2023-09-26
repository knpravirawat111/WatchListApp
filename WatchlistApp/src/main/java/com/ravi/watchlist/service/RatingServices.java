package com.ravi.watchlist.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class RatingServices {
String apiURL = "https://www.omdbapi.com/?apikey=bf3cddaa&t=";

public String getMovieRating(String title) {
	
	try {
		
		// for external api calling we use RestTemplate
		RestTemplate template = new RestTemplate();
		
		//API URL + titl	
	// object of Response Entity is  JSON type and called ObjectNode
		ResponseEntity<ObjectNode> response = template.getForEntity(apiURL + title, ObjectNode.class);
		ObjectNode jsonObject = response.getBody();
		System.out.println("shi movie h");
		return jsonObject.path("imdbRating").asText();
		
	}catch (Exception e){
    System.out.println("Enter Movie Name is Not availble or wrong !" + e.getMessage());
    return null; 
	    
	}
}
}
