package com.mymovies.web.dtos;

import com.mymovies.models.Episode;

public class EpisodeDTO {

	private long id;
	private int serialNumber;
	private String name;
	
	private MovieTvShowDTO movieTvShow; //one to many
	private SeasonDTO season; //one to many
	
	public EpisodeDTO(Episode obj) {
		id = obj.getId();
		serialNumber = obj.getSerialNumber();
		name = obj.getName();
		if(obj.getMovieTvShow()!=null)
			movieTvShow = new MovieTvShowDTO(obj.getMovieTvShow());
		if(obj.getSeason()!=null)
			season = new SeasonDTO(obj.getSeason());
	}

	public EpisodeDTO(long id, int serialNumber, String name, MovieTvShowDTO movieTvShow, SeasonDTO season) {
		super();
		this.id = id;
		this.serialNumber = serialNumber;
		this.name = name;
		this.movieTvShow = movieTvShow;
		this.season = season;
	}

	public EpisodeDTO() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MovieTvShowDTO getMovieTvShow() {
		return movieTvShow;
	}

	public void setMovieTvShow(MovieTvShowDTO movieTvShow) {
		this.movieTvShow = movieTvShow;
	}

	public SeasonDTO getSeason() {
		return season;
	}

	public void setSeason(SeasonDTO season) {
		this.season = season;
	}
	
	
}
