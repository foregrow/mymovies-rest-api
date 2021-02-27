package com.mymovies.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymovies.enums.MovieTvShowType;
import com.mymovies.models.MovieTvShow;

public interface MovieTvShowRepository extends JpaRepository<MovieTvShow, Long> {

	List<MovieTvShow> findAllByTypeOrderByAvgRatingDesc(MovieTvShowType type);
	
	
	List<MovieTvShow> findByNameContains(String name);
	
	MovieTvShow findByNameAndReleaseYearAndLengthMinutes(String name, int year, int length);
}
