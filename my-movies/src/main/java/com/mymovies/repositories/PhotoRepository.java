package com.mymovies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.mymovies.models.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {

}
