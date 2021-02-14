package com.mymovies.web.dtos;


import com.mymovies.enums.ActorRole;
import com.mymovies.models.PersonMovieTvShow;

public class PersonMovieTvShowDTO {

	private long id;
	private String castName;
	private boolean director;
	private boolean writer;
	private boolean actor;
	private boolean composer;
	
	private ActorRole actorRole;
	
	private MovieTvShowDTO movieTvShow; //one to many
	private PersonDTO person; //one to many
	
	public PersonMovieTvShowDTO(PersonMovieTvShow obj) {
		id = obj.getId();
		castName = obj.getCastName();
		director = obj.isDirector();
		writer = obj.isWriter();
		actor = obj.isActor();
		composer = obj.isComposer();
		actorRole = obj.getActorRole();
		if(obj.getMovieTvShow()!=null) {
			movieTvShow = new MovieTvShowDTO(obj.getMovieTvShow());
		}
		if(obj.getPerson()!=null) {
			person = new PersonDTO(obj.getPerson());
			person.setPhotos(obj.getPerson().getPhotos());
		}
	}
	
	public PersonMovieTvShowDTO() {}

	public PersonMovieTvShowDTO(long id, String castName, boolean director, boolean writer, boolean actor,
			boolean composer, ActorRole actorRole, MovieTvShowDTO movieTvShow, PersonDTO person) {
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

	
}
