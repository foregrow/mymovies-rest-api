package com.mymovies.services;

import com.mymovies.models.PersonMovieTvShow;
import com.mymovies.web.dtos.PersonMovieTvShowDTO;

public interface PersonMovieTvShowService extends CrudService<PersonMovieTvShow, PersonMovieTvShowDTO>, DTOService<PersonMovieTvShow, PersonMovieTvShowDTO> {

	PersonMovieTvShow findByPersonIdAndMovieTvShowId(long pid, long mtsid);
}
