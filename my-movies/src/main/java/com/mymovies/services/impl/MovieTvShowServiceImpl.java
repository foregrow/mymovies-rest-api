package com.mymovies.services.impl;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovies.enums.MovieTvShowType;
import com.mymovies.models.Genre;
import com.mymovies.models.MovieTvShow;
import com.mymovies.models.Trailer;
import com.mymovies.models.UserMovieTvShow;
import com.mymovies.repositories.MovieTvShowRepository;
import com.mymovies.services.EntityInstanceService;
import com.mymovies.services.GenreService;
import com.mymovies.services.MovieTvShowService;
import com.mymovies.services.TrailerService;
import com.mymovies.services.UserMovieTvShowService;
import com.mymovies.web.dtos.GenreDTO;
import com.mymovies.web.dtos.ImdbMovieDTO;
import com.mymovies.web.dtos.MovieTvShowDTO;
import com.mymovies.web.dtos.TrailerDTO;

@Service
public class MovieTvShowServiceImpl implements MovieTvShowService {

	@Autowired
	MovieTvShowRepository mtsr;
	
	@Autowired
	EntityInstanceService eis;
	
	@Autowired
	TrailerService ts;
	
	@Autowired
	GenreService gs;
	
	@Autowired
	UserMovieTvShowService umtss;
	
	@Override
	public List<MovieTvShow> getAll() {
		return mtsr.findAll();
	}
	
	@Override
	public List<MovieTvShow> findAllByType(MovieTvShowType type) {
		return mtsr.findAllByTypeOrderByAvgRatingDesc(type);
	}

	@Override
	public MovieTvShow getById(long id) {
		return mtsr.findById(id).orElse(null);
	}
	
	@Override
	public MovieTvShow saveImdbMovie(ImdbMovieDTO obj) {
		MovieTvShow foundMts = mtsr.findByNameAndReleaseYearAndLengthMinutes(obj.getTitle(),obj.getYear(),obj.getLength());
		if(obj!=null&&foundMts==null) {
			MovieTvShow mts = new MovieTvShow();
			mts.setReleaseYear(obj.getYear());
			mts.setName(obj.getTitle());
			mts.setLengthMinutes(obj.getLength());
			if(obj.getType().equals("tvSeries"))
				mts.setType(MovieTvShowType.TV_SHOW);
			else
				mts.setType(MovieTvShowType.MOVIE);
			mts.setCountry("USA");
			mts.setLanguage("ENG");
			mts.setReleaseDate(new Date(obj.getYear()));
			return mtsr.save(mts);
			
		}
		return null;
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
			mts.setAvgRating(0);
			mtsr.save(mts);
			if(obj.getGenres().size()>0) {
				Genre g = null;
				for(GenreDTO gdto : obj.getGenres()) {
					g = gs.getByType(gdto.getType());
					g.getMoviesTvShows().add(mts);
					gs.save(g);
					
					
				}
			}
			
			if(obj.getTrailers().size()>0) {
				Trailer t = null;
				for(TrailerDTO tdto : obj.getTrailers()) {
					t = new Trailer();
					t.setName(mts.getName());
					t.setPath(tdto.getPath());
					t.setMovieTvShow(mts);
					ts.save(t);
				}
			}
			
			return mts;
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
				mts.setAvgRating(obj.getAvgRating());
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

	@Override
	public List<MovieTvShow> findAllByNameContains(String name) {
		return mtsr.findByNameContains(name);
	}

	@Override
	public MovieTvShow findByNameAndReleaseYearAndLengthMinutes(String name, int year, int length) {
		return mtsr.findByNameAndReleaseYearAndLengthMinutes(name, year, length);
	}
	
	public double calculateMTSAvgRating(int newRating,long mtsId) {
		List<UserMovieTvShow> umtsList = umtss.findByMovieTvShowId(mtsId);
		int counter = 0;
		int sumRating = 0;
		for(UserMovieTvShow umts : umtsList) {
			sumRating+=umts.getUserRating();
			counter++;
		}
		double avgRating = sumRating / counter;
		MovieTvShow mts = mtsr.getOne(mtsId);
		mts.setAvgRating(avgRating);
		mtsr.save(mts);
		return avgRating;
	}


	
}
