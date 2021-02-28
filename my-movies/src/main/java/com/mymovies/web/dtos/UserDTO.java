package com.mymovies.web.dtos;


import java.util.ArrayList;


import java.util.List;
import java.util.Set;

import com.mymovies.enums.UserRole;
import com.mymovies.models.User;
import com.mymovies.models.UserMovieTvShow;

public class UserDTO {

	private long id;
	private String email;
	private String password;
	private UserRole userRole;
	
	private PhotoDTO photo; //one to one
	private List<UserMovieTvShowDTO> moviesTvShows = new ArrayList<UserMovieTvShowDTO>(); //many to one
	
	
	public UserDTO(User obj) {
		id = obj.getId();
		email = obj.getEmail();
		password = obj.getPassword();
		userRole = obj.getUserRole();
		
		if(obj.getPhoto()!=null) {
			photo = new PhotoDTO(obj.getPhoto());
		}
			
	}
	
	public UserDTO() {}

	public UserDTO(long id, String email, String password, UserRole userRole, PhotoDTO photo,
			List<UserMovieTvShowDTO> moviesTvShows) {
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

	public PhotoDTO getPhoto() {
		return photo;
	}

	public void setPhoto(PhotoDTO photo) {
		this.photo = photo;
	}

	public List<UserMovieTvShowDTO> getMoviesTvShows() {
		return moviesTvShows;
	}

	public void setMoviesTvShows(Set<UserMovieTvShow> moviesTvShows) {
		for(UserMovieTvShow obj : moviesTvShows) {
			this.moviesTvShows.add(new UserMovieTvShowDTO(obj));
		}
	}


}
