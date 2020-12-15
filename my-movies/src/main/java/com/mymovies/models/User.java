package com.mymovies.models;

import java.util.HashSet;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.mymovies.enums.UserRole;
@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String email;
	private String password;
	private UserRole userRole;
	
	@OneToOne(mappedBy = "user")
	private Photo photo; //one to one
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	private Set<UserMovieTvShow> moviesTvShows = new HashSet<UserMovieTvShow>(); //many to one
	
	
	public User() {
		
	}

	public User(long id, String email, String password, UserRole userRole, Photo photo,
			Set<UserMovieTvShow> moviesTvShows) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.userRole = userRole;
		this.photo = photo;
		this.moviesTvShows = moviesTvShows;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public Set<UserMovieTvShow> getMoviesTvShows() {
		return moviesTvShows;
	}

	public void setMoviesTvShows(Set<UserMovieTvShow> moviesTvShows) {
		this.moviesTvShows = moviesTvShows;
	}
}
