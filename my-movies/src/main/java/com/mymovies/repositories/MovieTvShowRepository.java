package com.mymovies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;



import com.mymovies.models.MovieTvShow;

public interface MovieTvShowRepository extends JpaRepository<MovieTvShow, Long> {

}
