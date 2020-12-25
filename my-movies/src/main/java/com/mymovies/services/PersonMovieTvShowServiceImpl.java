
package com.mymovies.services;

import java.util.ArrayList;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovies.models.MovieTvShow;
import com.mymovies.models.Person;
import com.mymovies.models.PersonMovieTvShow;
import com.mymovies.repositories.PersonMovieTvShowRepository;
import com.mymovies.web.dtos.PersonMovieTvShowDTO;
@Service
public class PersonMovieTvShowServiceImpl implements PersonMovieTvShowService {

	@Autowired
	PersonMovieTvShowRepository pmtsr;
	
	@Autowired
	MovieTvShowService mtss;
	
	@Autowired
	PersonService ps;
	
	@Autowired
	EntityInstanceService eis;

	@Override
	public List<PersonMovieTvShow> getAll() {
		return pmtsr.findAll();
	}

	@Override
	public PersonMovieTvShow getById(long id) {
		// TODO Auto-generated method stub
		return pmtsr.findById(id).orElse(null);
	}

	@Override
	public PersonMovieTvShow create(PersonMovieTvShowDTO obj) {
		if(obj!=null&&obj.getMovieTvShow()!=null&&obj.getPerson()!=null) {
			MovieTvShow mts = mtss.getById(obj.getMovieTvShow().getId());
			Person person = ps.getById(obj.getPerson().getId());
			if(mts!=null&&person!=null) {
				PersonMovieTvShow pm = (PersonMovieTvShow) eis.getEntityByDTO(obj);
				pm.setCastName(obj.getCastName());
				pm.setDirector(obj.isDirector());
				pm.setActor(obj.isActor());
				pm.setWriter(obj.isWriter());
				pm.setComposer(obj.isComposer());
				pm.setActorRole(obj.getActorRole());
				pm.setMovieTvShow(mts);
				pm.setPerson(person);
				return pmtsr.save(pm);
			}
			
		}
		return null;
	}

	@Override
	public void deleteById(long id) {
		pmtsr.deleteById(id);
		
	}

	@Override
	public PersonMovieTvShow update(PersonMovieTvShowDTO obj) {
		if(obj!=null&&obj.getMovieTvShow()!=null&&obj.getPerson()!=null) {
			PersonMovieTvShow pm = findByPersonIdAndMovieTvShowId(obj.getPerson().getId(), obj.getMovieTvShow().getId());
			if(pm!=null) {
				pm.setCastName(obj.getCastName());
				pm.setDirector(obj.isDirector());
				pm.setActor(obj.isActor());
				pm.setWriter(obj.isWriter());
				pm.setComposer(obj.isComposer());
				pm.setActorRole(obj.getActorRole());
				return pmtsr.save(pm);
			}
		}
		return null;
		
	}

	@Override
	public List<PersonMovieTvShowDTO> getAllDTOs(List<PersonMovieTvShow> objs) {
		List<PersonMovieTvShowDTO> dtos = new ArrayList<PersonMovieTvShowDTO>();
		objs.forEach(el->{
			PersonMovieTvShowDTO dto = new PersonMovieTvShowDTO(el);
			dtos.add(dto);
		});
		
		return dtos;
	}

	@Override
	public PersonMovieTvShowDTO getSingleDTO(PersonMovieTvShow obj) {
		PersonMovieTvShowDTO dto = new PersonMovieTvShowDTO(obj);
		return dto;
	}

	@Override
	public PersonMovieTvShow findByPersonIdAndMovieTvShowId(long pid, long mtsid) {
		return pmtsr.findByPersonIdAndMovieTvShowId(pid, mtsid);
	}
	
	

}
