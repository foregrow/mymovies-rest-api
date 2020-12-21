package com.mymovies.services;

import com.mymovies.models.UserMovieTvShow;
import com.mymovies.web.dtos.UserMovieTvShowDTO;

public interface UserMovieTvShowService extends CrudService<UserMovieTvShow, UserMovieTvShowDTO> , DTOService<UserMovieTvShow, UserMovieTvShowDTO> {

	UserMovieTvShow findByUserEmailAndMovieTvShowId(String email, long mtsid);
}
