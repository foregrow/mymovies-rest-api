package com.mymovies.models;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.mymovies.enums.GenreType;
@Entity
public class Genre   {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private GenreType type;
	
	@ManyToMany
	@JoinTable(name="genres_mts", joinColumns= {@JoinColumn(name="genre_id")},
	inverseJoinColumns= {@JoinColumn(name="mts_id")})
	private Set<MovieTvShow> moviesTvShows = new HashSet<MovieTvShow>(); //many to many
	
	public Genre() {
		
	}

	public Genre(long id, GenreType type, Set<MovieTvShow> moviesTvShows) {
		super();
		this.id = id;
		this.type = type;
		this.moviesTvShows = moviesTvShows;
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

	public Set<MovieTvShow> getMoviesTvShows() {
		return moviesTvShows;
	}

	public void setMoviesTvShows(Set<MovieTvShow> moviesTvShows) {
		this.moviesTvShows = moviesTvShows;
	}
	
	
	
}
