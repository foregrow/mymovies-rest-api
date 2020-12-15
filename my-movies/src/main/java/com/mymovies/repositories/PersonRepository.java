package com.mymovies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.mymovies.models.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
