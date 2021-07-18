package com.example.three;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/catalog")
public class Movicatologue {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder ;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem>getCatalog(@PathVariable("userId")String userId){
		
		//get all rated movie ids
		// for each movie Id call movie info service for the details
		
//		RestTemplate restTemplate=new RestTemplate();
		
		
		// get the movies a person watched
		
//		WebClient.Builder builder= WebClient.builder();
		
		List<Rating> ratings=Arrays.asList(
				new Rating("12",4),
				new Rating("13",3)
				);
		
		return ratings.stream().map(rating->{
//			Movieinfo movie =restTemplate.getForObject("http://localhost:8080/movies/1"+ rating.getMovieId(),Movieinfo.class);
			
			Movieinfo movie =webClientBuilder.build().get().uri("http://localhost:8080/movies/1"+ rating.getMovieId()).retrieve().bodyToMono(Movieinfo.class).block();
			
			return new CatalogItem(movie.getName(),"comedy",rating.getRating());
					}).collect(Collectors.toList());
		
//		return Collections.singletonList(new CatalogItem("BBT","Comedy",8));
	}
}
