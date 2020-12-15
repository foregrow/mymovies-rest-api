package com.mymovies.models;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class UserMovieTvShow{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private int userRating;
	private boolean watchLater; 
	private boolean watchlist; 
	private boolean reviewed;
	private String userReview;
	
	@ManyToOne
	private MovieTvShow movieTvShow; //one to many
	
	@ManyToOne
	private User user; //one to many
	
	public UserMovieTvShow() {
		
	}

	public UserMovieTvShow(long id, int userRating, boolean watchLater, boolean watchlist, boolean reviewed,
			String userReview, MovieTvShow movieTvShow, User user) {
		super();
		this.id = id;
		this.userRating = userRating;
		this.watchLater = watchLater;
		this.watchlist = watchlist;
		this.reviewed = reviewed;
		this.userReview = userReview;
		this.movieTvShow = movieTvShow;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getUserRating() {
		return userRating;
	}

	public void setUserRating(int userRating) {
		this.userRating = userRating;
	}

	public boolean isWatchLater() {
		return watchLater;
	}

	public void setWatchLater(boolean watchLater) {
		this.watchLater = watchLater;
	}

	public boolean isWatchlist() {
		return watchlist;
	}

	public void setWatchlist(boolean watchlist) {
		this.watchlist = watchlist;
	}

	public boolean isReviewed() {
		return reviewed;
	}

	public void setReviewed(boolean reviewed) {
		this.reviewed = reviewed;
	}

	public String getUserReview() {
		return userReview;
	}

	public void setUserReview(String userReview) {
		this.userReview = userReview;
	}

	public MovieTvShow getMovieTvShow() {
		return movieTvShow;
	}

	public void setMovieTvShow(MovieTvShow movieTvShow) {
		this.movieTvShow = movieTvShow;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
