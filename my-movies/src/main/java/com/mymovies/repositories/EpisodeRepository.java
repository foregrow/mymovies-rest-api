package com.mymovies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.mymovies.models.Episode;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {

}
