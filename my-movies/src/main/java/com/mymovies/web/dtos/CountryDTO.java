package com.mymovies.web.dtos;

import java.util.ArrayList;
import java.util.List;

public class CountryDTO {

	private String name;
	private List<LanguageDTO> languages = new ArrayList<LanguageDTO>();
	public CountryDTO() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<LanguageDTO> getLanguages() {
		return languages;
	}

	public void setLanguages(List<LanguageDTO> languages) {
		this.languages = languages;
	}
	
	
}
