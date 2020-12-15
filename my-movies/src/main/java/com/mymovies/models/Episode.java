package com.mymovies.models;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Episode   {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private int serialNumber;
	private String name;
	
	@ManyToOne
	private MovieTvShow movieTvShow; //one to many
	
	@ManyToOne
	private Season season; //one to many
	
	public Episode() {
		
	}

	public Episode(long id, int serialNumber, String name, MovieTvShow movieTvShow, Season season) {
		super();
		this.id = id;
		this.serialNumber = serialNumber;
		this.name = name;
		this.movieTvShow = movieTvShow;
		this.season = season;
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

	public MovieTvShow getMovieTvShow() {
		return movieTvShow;
	}

	public void setMovieTvShow(MovieTvShow movieTvShow) {
		this.movieTvShow = movieTvShow;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}
	
	
}
