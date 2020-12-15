package com.mymovies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.mymovies.models.Season;

public interface SeasonRepository extends JpaRepository<Season, Long> {

}
