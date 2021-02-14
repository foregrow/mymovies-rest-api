package com.mymovies.web.dtos;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.mymovies.models.Person;
import com.mymovies.models.PersonMovieTvShow;
import com.mymovies.models.Photo;

public class PersonDTO {

	private long id;
	private String firstName;
	private String lastName;
	private String bio;
	private Date bornDate;
	private Date diedDate;
	
	private List<PersonMovieTvShowDTO> moviesTvShows = new ArrayList<PersonMovieTvShowDTO>(); //many to one
	private List<PhotoDTO> photos = new ArrayList<PhotoDTO>(); //many to one
	
	
	public PersonDTO(Person obj) {
		id = obj.getId();
		firstName = obj.getFirstName();
		lastName = obj.getLastName();
		bio = obj.getBio();
		bornDate = obj.getBornDate();
		diedDate = obj.getDiedDate();
	}
	
	public PersonDTO(long id, String firstName, String lastName, String bio, Date bornDate, Date diedDate,
			List<PersonMovieTvShowDTO> moviesTvShows, List<PhotoDTO> photos) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.bio = bio;
		this.bornDate = bornDate;
		this.diedDate = diedDate;
		this.moviesTvShows = moviesTvShows;
		this.photos = photos;
	}

	public PersonDTO() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Date getBornDate() {
		return bornDate;
	}

	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}

	public Date getDiedDate() {
		return diedDate;
	}

	public void setDiedDate(Date diedDate) {
		this.diedDate = diedDate;
	}

	public List<PersonMovieTvShowDTO> getMoviesTvShows() {
		return moviesTvShows;
	}

	public void setMoviesTvShows(Set<PersonMovieTvShow> moviesTvShows) {
		for(PersonMovieTvShow obj : moviesTvShows) {
			
			this.moviesTvShows.add(new PersonMovieTvShowDTO(obj));
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
