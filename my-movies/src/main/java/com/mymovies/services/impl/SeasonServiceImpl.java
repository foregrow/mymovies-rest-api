package com.mymovies.services.impl;

import java.util.ArrayList;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovies.models.MovieTvShow;
import com.mymovies.models.Season;
import com.mymovies.repositories.SeasonRepository;
import com.mymovies.services.MovieTvShowService;
import com.mymovies.services.SeasonService;
import com.mymovies.web.dtos.SeasonDTO;
@Service
public class SeasonServiceImpl implements SeasonService {

	@Autowired
	SeasonRepository sr;
	
	@Autowired
	MovieTvShowService mtss;


	@Override
	public List<Season> getAll() {
		return sr.findAll();
	}

	@Override
	public Season getById(long id) {
		return sr.findById(id).orElse(null);
	}

	@Override
	public Season create(SeasonDTO obj) {
		if(obj!=null&&obj.getMovieTvShow()!=null) {
			MovieTvShow mts = mtss.getById(obj.getMovieTvShow().getId());
			if(mts!=null) {
				Season s = new Season();
				s.setSerialNumber(obj.getSerialNumber());
				s.setReleaseYear(obj.getReleaseYear());
				s.setMovieTvShow(mts);
				return sr.save(s);
			}
		}
		return null;
	}

	@Override
	public void deleteById(long id) {
		sr.deleteById(id);
		
	}

	@Override
	public Season update(SeasonDTO obj) {
		if(obj!=null) {
			Season season = getById(obj.getId());
			if(season!=null) {
				season.setReleaseYear(obj.getReleaseYear());
				season.setSerialNumber(obj.getSerialNumber());
				return sr.save(season);
			}
		}
		return null;
		
	}

	@Override
	public List<SeasonDTO> getAllDTOs(List<Season> objs) {
		List<SeasonDTO> dtos = new ArrayList<SeasonDTO>();
		objs.forEach(el->{
			SeasonDTO dto = new SeasonDTO(el);
			dto.setEpisodes(el.getEpisodes());
			dtos.add(dto);
		});
		
		return dtos;
	}

	@Override
	public SeasonDTO getSingleDTO(Season obj) {
		SeasonDTO dto = new SeasonDTO(obj);
		dto.setEpisodes(obj.getEpisodes());
		return dto;
	}
	
	

}
