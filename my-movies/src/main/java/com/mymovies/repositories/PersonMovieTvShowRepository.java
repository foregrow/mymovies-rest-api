package com.mymovies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;



import com.mymovies.models.PersonMovieTvShow;

public interface PersonMovieTvShowRepository extends JpaRepository<PersonMovieTvShow, Long> {

	PersonMovieTvShow findByPersonIdAndMovieTvShowId(long pid, long mtsid);
}
