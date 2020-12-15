package com.mymovies.web.dtos;

import com.mymovies.models.Trailer;
public class TrailerDTO {

	private long id;
	private String name;
	private String path;
	
	private MovieTvShowDTO movieTvShow; //one to many
	
	public TrailerDTO(Trailer obj) {
		id = obj.getId();
		name = obj.getName();
		path = obj.getPath();
		
		if(obj.getMovieTvShow()!=null)
			movieTvShow = new MovieTvShowDTO(obj.getMovieTvShow());
	}
	

	public TrailerDTO(long id, String name, String path, MovieTvShowDTO movieTvShow) {
		super();
		this.id = id;
		this.name = name;
		this.path = path;
		this.movieTvShow = movieTvShow;
	}

	public TrailerDTO() {
		// TODO Auto-generated constructor stub
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public MovieTvShowDTO getMovieTvShow() {
		return movieTvShow;
	}

	public void setMovieTvShow(MovieTvShowDTO movieTvShow) {
		this.movieTvShow = movieTvShow;
	}


}
