package com.mymovies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymovies.models.Trailer;

public interface TrailerRepository extends JpaRepository<Trailer, Long> {

}
