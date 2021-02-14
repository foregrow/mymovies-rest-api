package com.mymovies.models;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Photo{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private String path;
	private String type;
	@Column(length = 100000)
	@Lob
	private byte[] picByte;
	@ManyToOne
	private MovieTvShow movieTvShow; //one to many
	
	@ManyToOne
	private Person person; //one to many
	
	@OneToOne
	private User user; //one to one
	
	public Photo() {
		
	}


	public Photo(long id, String name, String path, String type, byte[] picByte, MovieTvShow movieTvShow, Person person,
			User user) {
		super();
		this.id = id;
		this.name = name;
		this.path = path;
		this.type = type;
		this.picByte = picByte;
		this.movieTvShow = movieTvShow;
		this.person = person;
		this.user = user;
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

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public byte[] getPicByte() {
		return picByte;
	}


	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}


	public MovieTvShow getMovieTvShow() {
		return movieTvShow;
	}

	public void setMovieTvShow(MovieTvShow movieTvShow) {
		this.movieTvShow = movieTvShow;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
