package com.mymovies.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mymovies.models.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	
	//select p.* from person p where p.id not in (1,4);
	//List<Person> findAvailablePersonsForMTSCast(List<Integer> )
	
	@Query("select pp from Person pp where pp.id not in (select p.id from Person p, PersonMovieTvShow pmts where p.id=pmts.person.id AND pmts.movieTvShow.id = :mtsid)")
	List<Person> findAllPersonsNotInMTS(long mtsid);
	
	List<Person> findAllByIdIsNot(long mtsid);
	
}
