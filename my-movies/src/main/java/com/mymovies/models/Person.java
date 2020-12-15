package com.mymovies.models;

import java.util.Date;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person   {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String firstName;
	private String lastName;
	private String bio;
	private Date bornDate;
	private Date diedDate;
	
	@OneToMany(mappedBy = "person", cascade = CascadeType.REMOVE)
	private Set<PersonMovieTvShow> moviesTvShows = new HashSet<PersonMovieTvShow>(); //many to one
	
	@OneToMany(mappedBy = "person", cascade = CascadeType.REMOVE)
	private Set<Photo> photos = new HashSet<Photo>(); //many to one
	
	
	public Person() {
		
	}

	public Person(long id, String firstName, String lastName, String bio, Date bornDate, Date diedDate,
			Set<PersonMovieTvShow> moviesTvShows, Set<Photo> photos) {
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

	public Set<PersonMovieTvShow> getMoviesTvShows() {
		return moviesTvShows;
	}

	public void setMoviesTvShows(Set<PersonMovieTvShow> moviesTvShows) {
		this.moviesTvShows = moviesTvShows;
	}

	public Set<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}

}
