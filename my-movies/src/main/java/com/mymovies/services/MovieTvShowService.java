package com.mymovies.services;

import java.util.List;

import com.mymovies.enums.MovieTvShowType;
import com.mymovies.models.MovieTvShow;
import com.mymovies.web.dtos.MovieTvShowDTO;

public interface MovieTvShowService extends CrudService<MovieTvShow, MovieTvShowDTO>, DTOService<MovieTvShow, MovieTvShowDTO> {

	List<MovieTvShow> findAllByType(MovieTvShowType type);
}
