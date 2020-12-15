package com.mymovies.web.dtos;

import java.util.ArrayList;
import java.util.List;


public class ChannelMoviesDTO {


	private int id;
	private String title;
	private String shortDescription;
	private String startTime;
	private List<Integer> categories = new ArrayList<Integer>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public List<Integer> getCategories() {
		return categories;
	}
	public void setCategories(List<Integer> categories) {
		this.categories = categories;
	}
	
	
	
}
