package com.mymovies.services;

import java.util.List;

import com.mymovies.models.PersonMovieTvShow;
import com.mymovies.web.dtos.PersonMovieTvShowDTO;

public interface PersonMovieTvShowService extends CrudService<PersonMovieTvShow, PersonMovieTvShowDTO>, DTOService<PersonMovieTvShow, PersonMovieTvShowDTO> {

	PersonMovieTvShow findByPersonIdAndMovieTvShowId(long pid, long mtsid);
	
	List<PersonMovieTvShow> findByMovieTvShowId(long mtsid);
	
	List<PersonMovieTvShow> findByPersonId(long pid);
}
