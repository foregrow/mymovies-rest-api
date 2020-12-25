package com.mymovies.web.dtos;

import java.util.ArrayList;


import java.util.List;
import java.util.Set;

import com.mymovies.models.Episode;
import com.mymovies.models.Season;

public class SeasonDTO {

	private long id;
	private int serialNumber;
	private int releaseYear;
	
	private MovieTvShowDTO movieTvShow; //one to many	
	private List<EpisodeDTO> episodes = new ArrayList<EpisodeDTO>(); //many to one
	
	public SeasonDTO(Season obj) {
		id = obj.getId();
		serialNumber = obj.getSerialNumber();
		releaseYear = obj.getReleaseYear();
		if(obj.getMovieTvShow()!=null)
			movieTvShow = new MovieTvShowDTO(obj.getMovieTvShow());
		
	}
	public SeasonDTO() {}
	

	public SeasonDTO(long id, int serialNumber, int releaseYear, MovieTvShowDTO movieTvShow, List<EpisodeDTO> episodes) {
		super();
		this.id = id;
		this.serialNumber = serialNumber;
		this.releaseYear = releaseYear;
		this.movieTvShow = movieTvShow;
		this.episodes = episodes;
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

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public MovieTvShowDTO getMovieTvShow() {
		return movieTvShow;
	}

	public void setMovieTvShow(MovieTvShowDTO movieTvShow) {
		this.movieTvShow = movieTvShow;
	}


	public List<EpisodeDTO> getEpisodes() {
		return episodes;
	}


	public void setEpisodes(Set<Episode> episodes) {
		for(Episode obj : episodes) {
			this.episodes.add(new EpisodeDTO(obj));
		}
	}


}
