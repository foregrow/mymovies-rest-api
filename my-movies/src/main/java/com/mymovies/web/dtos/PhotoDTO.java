package com.mymovies.web.dtos;

import com.mymovies.models.Photo;
public class PhotoDTO {

	private long id;
	private String name;
	private String path;
	
	private MovieTvShowDTO movieTvShow; //one to many
	private PersonDTO person; //one to many
	private UserDTO user; //one to one
	

	public PhotoDTO(Photo obj) {
		id = obj.getId();
		name = obj.getName();
		path = obj.getPath();
		
		if(obj.getMovieTvShow()!=null)
			movieTvShow = new MovieTvShowDTO(obj.getMovieTvShow());
		if(obj.getPerson()!=null)
			person = new PersonDTO(obj.getPerson());
	}

	public PhotoDTO(long id, String name, String path, MovieTvShowDTO movieTvShow, PersonDTO person, UserDTO user) {
		super();
		this.id = id;
		this.name = name;
		this.path = path;
		this.movieTvShow = movieTvShow;
		this.person = person;
		this.user = user;
	}

	public PhotoDTO() {
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public MovieTvShowDTO getMovieTvShow() {
		return movieTvShow;
	}

	public void setMovieTvShow(MovieTvShowDTO movieTvShow) {
		this.movieTvShow = movieTvShow;
	}

	public PersonDTO getPerson() {
		return person;
	}

	public void setPerson(PersonDTO person) {
		this.person = person;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}


	
}
