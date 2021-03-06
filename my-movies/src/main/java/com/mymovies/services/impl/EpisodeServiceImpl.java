package com.mymovies.services.impl;

import java.util.ArrayList;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovies.models.Episode;
import com.mymovies.models.MovieTvShow;
import com.mymovies.models.Season;
import com.mymovies.repositories.EpisodeRepository;
import com.mymovies.services.EpisodeService;
import com.mymovies.services.MovieTvShowService;
import com.mymovies.services.SeasonService;
import com.mymovies.web.dtos.EpisodeDTO;

@Service
public class EpisodeServiceImpl implements EpisodeService {

	@Autowired
	EpisodeRepository er;
	

	@Autowired
	SeasonService ss;
	
	@Autowired
	MovieTvShowService mtss;
	
	@Override
	public List<Episode> getAll() {
		return er.findAll();
	}

	@Override
	public Episode getById(long id) {
		return er.findById(id).orElse(null);
	}

	@Override
	public Episode create(EpisodeDTO obj) {
		
		if(obj!=null&&obj.getMovieTvShow()!=null && obj.getSeason()!=null) {
			
			MovieTvShow mts = mtss.getById(obj.getMovieTvShow().getId());
			Season s = ss.getById(obj.getSeason().getId());
			if(mts!=null&&s!=null) {
				Episode es = new Episode();
				es.setSerialNumber(obj.getSerialNumber());
				es.setName(obj.getName());
				es.setMovieTvShow(mts);
				es.setSeason(s);
				
				return er.save(es);
			}
			
		}
		
		return null;
	}

	@Override
	public void deleteById(long id) {
		er.deleteById(id);		
	}

	@Override
	public Episode update(EpisodeDTO obj) {
		Episode ep = getById(obj.getId());
		if(ep!=null) {
			ep.setName(obj.getName());
			return er.save(ep);
		}
		return null;
		
	}

	@Override
	public List<EpisodeDTO> getAllDTOs(List<Episode> objs) {
		List<EpisodeDTO> dtos = new ArrayList<EpisodeDTO>();
		objs.forEach(el->{
			EpisodeDTO dto = new EpisodeDTO(el);
			dtos.add(dto);
		});
		
		return dtos;
	}


	@Override
	public EpisodeDTO getSingleDTO(Episode obj) {
		EpisodeDTO dto = new EpisodeDTO(obj);
		return dto;
	}

}
