package com.mymovies.web.dtos;

import com.mymovies.models.UserMovieTvShow;

public class UserMovieTvShowDTO {

	private long id;
	private int userRating;
	private boolean watchLater; 
	private boolean watchlist; 
	private boolean reviewed;
	private String userReview;
	
	private MovieTvShowDTO movieTvShow; //one to many
	private UserDTO user; //one to many
	
	public UserMovieTvShowDTO(UserMovieTvShow obj) {
		id = obj.getId();
		userRating = obj.getUserRating();
		watchLater = obj.isWatchLater();
		watchlist = obj.isWatchlist();
		reviewed = obj.isReviewed();
		userReview = obj.getUserReview();
		
		if(obj.getMovieTvShow()!=null) {
			movieTvShow = new MovieTvShowDTO(obj.getMovieTvShow());
			movieTvShow.setPhotos(obj.getMovieTvShow().getPhotos());
		}
			
		if(obj.getUser()!=null)
			user = new UserDTO(obj.getUser());
	}

	public UserMovieTvShowDTO(long id, int userRating, boolean watchLater, boolean watchlist, boolean reviewed,
			String userReview, MovieTvShowDTO movieTvShow, UserDTO user) {
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

	public UserMovieTvShowDTO() {
		// TODO Auto-generated constructor stub
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

	public MovieTvShowDTO getMovieTvShow() {
		return movieTvShow;
	}

	public void setMovieTvShow(MovieTvShowDTO movieTvShow) {
		this.movieTvShow = movieTvShow;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}


}
