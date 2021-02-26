package com.mymovies.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



import com.mymovies.models.UserMovieTvShow;

public interface UserMovieTvShowRepository extends JpaRepository< UserMovieTvShow, Long> {

	UserMovieTvShow findByUserEmailAndMovieTvShowId(String email, long mtsid);
	
	List<UserMovieTvShow> findByMovieTvShowId(long mtsid);
}
