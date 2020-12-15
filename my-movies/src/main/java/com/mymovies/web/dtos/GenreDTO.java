package com.mymovies.web.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.mymovies.enums.GenreType;
import com.mymovies.models.Genre;
import com.mymovies.models.MovieTvShow;

public class GenreDTO {

	private long id;
	private GenreType type;
	
	private List<MovieTvShowDTO> moviesTvShows = new ArrayList<MovieTvShowDTO>(); //many to many
	
	public GenreDTO(Genre obj) {
		id = obj.getId();
		type = obj.getType();
	}

	public GenreDTO(long id, GenreType type, List<MovieTvShowDTO> moviesTvShows) {
		super();
		this.id = id;
		this.type = type;
		this.moviesTvShows = moviesTvShows;
	}

	public GenreDTO() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public GenreType getType() {
		return type;
	}

	public void setType(GenreType type) {
		this.type = type;
	}

	public List<MovieTvShowDTO> getMoviesTvShows() {
		return moviesTvShows;
	}

	public void setMoviesTvShows(Set<MovieTvShow> moviesTvShows) {
		for(MovieTvShow obj : moviesTvShows) {
			this.moviesTvShows.add(new MovieTvShowDTO(obj));
		}
		 
	}
	
	
}
