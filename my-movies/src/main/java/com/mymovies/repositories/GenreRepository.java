package com.mymovies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;



import com.mymovies.models.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
