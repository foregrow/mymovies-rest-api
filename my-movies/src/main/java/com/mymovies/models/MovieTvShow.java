package com.mymovies.models;

import java.util.Date;





import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.mymovies.enums.MovieTvShowType;
@Entity
public class MovieTvShow   {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private String description;
	private String storyline;
	private int lengthMinutes;
	private Date releaseDate;
	private int releaseYear;
	private MovieTvShowType type; //movie or tv show
	private String country;
	private String language;
	private double avgRating;
	
	@OneToMany(mappedBy = "movieTvShow", cascade = CascadeType.REMOVE)
	private Set<Trailer> trailers = new HashSet<Trailer>(); //many to one
	
	@OneToMany(mappedBy = "movieTvShow", cascade = CascadeType.REMOVE)
	private Set<Season> seasons = new HashSet<Season>(); //many to one
	
	@OneToMany(mappedBy = "movieTvShow", cascade = CascadeType.REMOVE)
	private Set<Episode> episodes = new HashSet<Episode>(); //many to one
	
	@OneToMany(mappedBy = "movieTvShow", cascade = CascadeType.REMOVE)
	private Set<UserMovieTvShow> users = new HashSet<UserMovieTvShow>();//many to one
	
	@OneToMany(mappedBy = "movieTvShow", cascade = CascadeType.REMOVE)
	private Set<PersonMovieTvShow> persons = new HashSet<PersonMovieTvShow>(); //many to one
	
	@ManyToMany(mappedBy="moviesTvShows")
	private Set<Genre> genres = new HashSet<Genre>(); //many to many
	
	
	@OneToMany(mappedBy = "movieTvShow", cascade = CascadeType.REMOVE)
	private Set<Photo> photos = new HashSet<Photo>(); //many to one
	
	
	public MovieTvShow() {
		
	}

	public MovieTvShow(long id, String name, String description, String storyline, int lengthMinutes, Date releaseDate,
			int releaseYear, MovieTvShowType type, String country, String language, double avgRating, Set<Trailer> trailers,
			Set<Season> seasons, Set<Episode> episodes, Set<UserMovieTvShow> users, Set<PersonMovieTvShow> persons,
			Set<Genre> genres, Set<Photo> photos) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.storyline = storyline;
		this.lengthMinutes = lengthMinutes;
		this.releaseDate = releaseDate;
		this.releaseYear = releaseYear;
		this.type = type;
		this.country = country;
		this.language = language;
		this.avgRating = avgRating;
		this.trailers = trailers;
		this.seasons = seasons;
		this.episodes = episodes;
		this.users = users;
		this.persons = persons;
		this.genres = genres;
		this.photos = photos;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStoryline() {
		return storyline;
	}

	public void setStoryline(String storyline) {
		this.storyline = storyline;
	}

	public int getLengthMinutes() {
		return lengthMinutes;
	}

	public void setLengthMinutes(int lengthMinutes) {
		this.lengthMinutes = lengthMinutes;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public MovieTvShowType getType() {
		return type;
	}

	public void setType(MovieTvShowType type) {
		this.type = type;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLanguage() {
		return language;
	}

	public double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	public Set<Trailer> getTrailers() {
		return trailers;
	}

	public void setTrailers(Set<Trailer> trailers) {
		this.trailers = trailers;
	}

	public Set<Season> getSeasons() {
		return seasons;
	}

	public void setSeasons(Set<Season> seasons) {
		this.seasons = seasons;
	}

	public Set<Episode> getEpisodes() {
		return episodes;
	}

	public void setEpisodes(Set<Episode> episodes) {
		this.episodes = episodes;
	}

	public Set<UserMovieTvShow> getUsers() {
		return users;
	}

	public void setUsers(Set<UserMovieTvShow> users) {
		this.users = users;
	}

	public Set<PersonMovieTvShow> getPersons() {
		return persons;
	}

	public void setPersons(Set<PersonMovieTvShow> persons) {
		this.persons = persons;
	}

	public Set<Genre> getGenres() {
		return genres;
	}

	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}

	public Set<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}

}
