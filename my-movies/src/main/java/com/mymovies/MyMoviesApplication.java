package com.mymovies;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class MyMoviesApplication {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	
	@Value("${param.newRating}")
	 public static String newRating;
	 
	 @Value("${param.watchlist}")
	 public static String watchlist;
	 
	 @Value("${param.watchlater}")
	 public static String watchlater;
	
	public static void main(String[] args) {
		SpringApplication.run(MyMoviesApplication.class, args);
	}

}
