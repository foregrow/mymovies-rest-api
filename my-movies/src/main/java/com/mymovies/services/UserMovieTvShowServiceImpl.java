package com.mymovies.services;

import java.util.ArrayList;

import java.util.List;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovies.models.UserMovieTvShow;
import com.mymovies.repositories.UserMovieTvShowRepository;
import com.mymovies.web.dtos.UserMovieTvShowDTO;
@Service

public class UserMovieTvShowServiceImpl implements UserMovieTvShowService {

	@Autowired
	UserMovieTvShowRepository umtsr;
	
	@Autowired
	FactoryEntityService fe;

	@Override
	public List<UserMovieTvShow> getAll() {
		return umtsr.findAll();
	}

	@Override
	public UserMovieTvShow getById(long id) {
		return umtsr.findById(id).orElse(null);
	}

	@Override
	public UserMovieTvShow create(UserMovieTvShowDTO obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(long id) {
		umtsr.deleteById(id);
		
	}

	@Override
	public void update(UserMovieTvShowDTO obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserMovieTvShowDTO> getAllDTOs(List<UserMovieTvShow> objs) {
		List<UserMovieTvShowDTO> dtos = new ArrayList<UserMovieTvShowDTO>();
		objs.forEach(el->{
			UserMovieTvShowDTO dto = new UserMovieTvShowDTO(el);
			dtos.add(dto);
		});
		
		return dtos;
	}

	@Override
	public UserMovieTvShowDTO getSingleDTO(UserMovieTvShow obj) {
		UserMovieTvShowDTO dto = new UserMovieTvShowDTO(obj);
		return dto;
	}
	

}
