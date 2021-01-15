package com.mymovies.services.impl;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovies.enums.MovieTvShowType;
import com.mymovies.models.MovieTvShow;
import com.mymovies.repositories.MovieTvShowRepository;
import com.mymovies.services.EntityInstanceService;
import com.mymovies.services.MovieTvShowService;
import com.mymovies.web.dtos.MovieTvShowDTO;
@Service
public class MovieTvShowServiceImpl implements MovieTvShowService {

	@Autowired
	MovieTvShowRepository mtsr;
	
	@Autowired
	EntityInstanceService eis;
	
	@Override
	public List<MovieTvShow> getAll() {
		return mtsr.findAll();
	}
	
	@Override
	public List<MovieTvShow> findAllByType(MovieTvShowType type) {
		return mtsr.findAllByType(type);
	}

	@Override
	public MovieTvShow getById(long id) {
		return mtsr.findById(id).orElse(null);
	}

	@Override
	public MovieTvShow create(MovieTvShowDTO obj) {
		if(obj!=null) {
			MovieTvShow mts = (MovieTvShow) eis.getEntityByDTO(obj);
			mts.setName(obj.getName());
			mts.setDescription(obj.getDescription());
			mts.setStoryline(obj.getStoryline());
			mts.setLengthMinutes(obj.getLengthMinutes());
			mts.setReleaseDate(obj.getReleaseDate());
			mts.setReleaseYear(obj.getReleaseYear());
			mts.setType(obj.getType());
			mts.setCountry(obj.getCountry());
			mts.setLanguage(obj.getLanguage());
			
			return mtsr.save(mts);
		}
		return null;
	}

	@Override
	public void deleteById(long id) {
		mtsr.deleteById(id);
		
	}

	@Override
	public MovieTvShow update(MovieTvShowDTO obj) {
		if(obj!=null) {
			MovieTvShow mts = getById(obj.getId());
			if(mts!=null) {
				mts.setName(obj.getName());
				mts.setDescription(obj.getDescription());
				mts.setStoryline(obj.getStoryline());
				mts.setLengthMinutes(obj.getLengthMinutes());
				mts.setReleaseDate(obj.getReleaseDate());
				mts.setReleaseYear(obj.getReleaseYear());
				mts.setCountry(obj.getCountry());
				mts.setLanguage(obj.getLanguage());
				return mtsr.save(mts);
			}
		}
		return null;
		
	}

	@Override
	public List<MovieTvShowDTO> getAllDTOs(List<MovieTvShow> objs) {
		List<MovieTvShowDTO> dtos = new ArrayList<MovieTvShowDTO>();
		objs.forEach(el->{
			MovieTvShowDTO dto = new MovieTvShowDTO(el);
			dto.setTrailers(el.getTrailers());
			dto.setSeasons(el.getSeasons());
			dto.setEpisodes(el.getEpisodes());
			dto.setUsers(el.getUsers());
			dto.setPersons(el.getPersons());
			dto.setGenres(el.getGenres());
			dto.setPhotos(el.getPhotos());
			dtos.add(dto);
		});
		
		return dtos;
	}

	@Override
	public MovieTvShowDTO getSingleDTO(MovieTvShow obj) {
		MovieTvShowDTO dto = new MovieTvShowDTO(obj);
		dto.setTrailers(obj.getTrailers());
		dto.setSeasons(obj.getSeasons());
		dto.setEpisodes(obj.getEpisodes());
		dto.setUsers(obj.getUsers());
		dto.setPersons(obj.getPersons());
		dto.setGenres(obj.getGenres());
		dto.setPhotos(obj.getPhotos());
		return dto;
	}

	
}
