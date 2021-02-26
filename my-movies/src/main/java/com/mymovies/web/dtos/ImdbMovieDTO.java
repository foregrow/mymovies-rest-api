package com.mymovies.web.dtos;

public class ImdbMovieDTO {

	private int length;
	private String title;
	private String type;
	private int year;
	
	
	public ImdbMovieDTO() {
		
	}


	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	@Override
	public String toString() {
		return "ImdbMovieDTO [length=" + length + ", title=" + title + ", type=" + type + ", year=" + year + "]";
	}
	
	
	
}
