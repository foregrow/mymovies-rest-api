package com.mymovies.web.dtos;


import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.mymovies.enums.MovieTvShowType;
import com.mymovies.models.Episode;
import com.mymovies.models.Genre;
import com.mymovies.models.MovieTvShow;
import com.mymovies.models.PersonMovieTvShow;
import com.mymovies.models.Photo;
import com.mymovies.models.Season;
import com.mymovies.models.Trailer;
import com.mymovies.models.UserMovieTvShow;

public class MovieTvShowDTO {

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
	
	private List<TrailerDTO> trailers = new ArrayList<TrailerDTO>(); //many to one
	private List<SeasonDTO> seasons = new ArrayList<SeasonDTO>(); //many to one
	private List<EpisodeDTO> episodes = new ArrayList<EpisodeDTO>(); //many to one
	private List<UserMovieTvShowDTO> users = new ArrayList<UserMovieTvShowDTO>();//many to one
	private List<PersonMovieTvShowDTO> persons = new ArrayList<PersonMovieTvShowDTO>(); //many to one
	private List<GenreDTO> genres = new ArrayList<GenreDTO>(); //many to many
	private List<PhotoDTO> photos = new ArrayList<PhotoDTO>(); //many to one
	
	
	public MovieTvShowDTO(MovieTvShow obj) {
		id = obj.getId();
		name = obj.getName();
		description = obj.getDescription();
		storyline = obj.getStoryline();
		lengthMinutes = obj.getLengthMinutes();
		releaseDate = obj.getReleaseDate();
		releaseYear = obj.getReleaseYear();
		type = obj.getType();
		country = obj.getCountry();
		language = obj.getLanguage();
	}

	public MovieTvShowDTO(long id, String name, String description, String storyline, int lengthMinutes, Date releaseDate,
			int releaseYear, MovieTvShowType type, String country, String language, List<TrailerDTO> trailers,
			List<SeasonDTO> seasons, List<EpisodeDTO> episodes, List<UserMovieTvShowDTO> users, List<PersonMovieTvShowDTO> persons,
			List<GenreDTO> genres, List<PhotoDTO> photos) {
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
		this.trailers = trailers;
		this.seasons = seasons;
		this.episodes = episodes;
		this.users = users;
		this.persons = persons;
		this.genres = genres;
		this.photos = photos;
	}

	public MovieTvShowDTO() {
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

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<TrailerDTO> getTrailers() {
		return trailers;
	}

	public void setTrailers(Set<Trailer> trailers) {
		for(Trailer obj : trailers) {
			this.trailers.add(new TrailerDTO(obj));
		}
	}

	public List<SeasonDTO> getSeasons() {
		return seasons;
	}

	public void setSeasons(Set<Season> seasons) {
		for(Season obj : seasons) {
			this.seasons.add(new SeasonDTO(obj));
		}
	}

	public List<EpisodeDTO> getEpisodes() {
		return episodes;
	}

	public void setEpisodes(Set<Episode> episodes) {
		for(Episode obj : episodes) {
			this.episodes.add(new EpisodeDTO(obj));
		}
	}

	public List<UserMovieTvShowDTO> getUsers() {
		return users;
	}

	public void setUsers(Set<UserMovieTvShow> users) {
		for(UserMovieTvShow obj : users) {
			this.users.add(new UserMovieTvShowDTO(obj));
		}
	}

	public List<PersonMovieTvShowDTO> getPersons() {
		return persons;
	}

	public void setPersons(Set<PersonMovieTvShow> persons) {
		for(PersonMovieTvShow obj : persons) {
			this.persons.add(new PersonMovieTvShowDTO(obj));
		}
	}

	public List<GenreDTO> getGenres() {
		return genres;
	}

	public void setGenres(Set<Genre> genres) {
		for(Genre obj : genres) {
			this.genres.add(new GenreDTO(obj));
		}
	}

	public List<PhotoDTO> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<Photo> photos) {
		for(Photo obj : photos) {
			this.photos.add(new PhotoDTO(obj));
		}
	}

}
