package com.mymovies.models;

import java.util.HashSet;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Season  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private int serialNumber;
	private int releaseYear;
	//private Trailer trailer;
	
	@ManyToOne
	private MovieTvShow movieTvShow; //one to many
	
	@OneToMany(mappedBy = "season", cascade = CascadeType.REMOVE)
	private Set<Episode> episodes = new HashSet<Episode>(); //many to one
	
	public Season() {
		
	}

	public Season(long id, int serialNumber, int releaseYear, MovieTvShow movieTvShow, Set<Episode> episodes) {
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

	public MovieTvShow getMovieTvShow() {
		return movieTvShow;
	}

	public void setMovieTvShow(MovieTvShow movieTvShow) {
		this.movieTvShow = movieTvShow;
	}

	public Set<Episode> getEpisodes() {
		return episodes;
	}

	public void setEpisodes(Set<Episode> episodes) {
		this.episodes = episodes;
	}
}
