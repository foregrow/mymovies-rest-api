package com.mymovies.services;

import java.util.List;

import com.mymovies.models.UserMovieTvShow;
import com.mymovies.web.dtos.UserMovieTvShowDTO;

public interface UserMovieTvShowService extends CrudService<UserMovieTvShow, UserMovieTvShowDTO> , DTOService<UserMovieTvShow, UserMovieTvShowDTO> {

	UserMovieTvShow findByUserEmailAndMovieTvShowId(String email, long mtsid);
	
	List<UserMovieTvShow> findByMovieTvShowId(long mtsid);
	
	void newUserRating(String email, long mtsId, int newRating);
}
