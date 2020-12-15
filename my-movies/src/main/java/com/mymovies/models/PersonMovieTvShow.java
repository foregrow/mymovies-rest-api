package com.mymovies.models;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.mymovies.enums.ActorRole;
@Entity
public class PersonMovieTvShow   {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String castName;
	private boolean director;
	private boolean writer;
	private boolean actor;
	private boolean composer;
	
	private ActorRole actorRole;
	
	@ManyToOne
	private MovieTvShow movieTvShow; //one to many
	
	@ManyToOne
	private Person person; //one to many
	
	public PersonMovieTvShow() {
		
	}

	public PersonMovieTvShow(long id, String castName, boolean director, boolean writer, boolean actor,
			boolean composer, ActorRole actorRole, MovieTvShow movieTvShow, Person person) {
		super();
		this.id = id;
		this.castName = castName;
		this.director = director;
		this.writer = writer;
		this.actor = actor;
		this.composer = composer;
		this.actorRole = actorRole;
		this.movieTvShow = movieTvShow;
		this.person = person;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCastName() {
		return castName;
	}

	public void setCastName(String castName) {
		this.castName = castName;
	}

	public boolean isDirector() {
		return director;
	}

	public void setDirector(boolean director) {
		this.director = director;
	}

	public boolean isWriter() {
		return writer;
	}

	public void setWriter(boolean writer) {
		this.writer = writer;
	}

	public boolean isActor() {
		return actor;
	}

	public void setActor(boolean actor) {
		this.actor = actor;
	}

	public boolean isComposer() {
		return composer;
	}

	public void setComposer(boolean composer) {
		this.composer = composer;
	}

	public ActorRole getActorRole() {
		return actorRole;
	}

	public void setActorRole(ActorRole actorRole) {
		this.actorRole = actorRole;
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
	
	
}
