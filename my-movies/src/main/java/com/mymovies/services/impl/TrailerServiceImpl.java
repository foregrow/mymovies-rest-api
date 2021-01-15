package com.mymovies.services.impl;

import java.util.ArrayList;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovies.models.Trailer;
import com.mymovies.repositories.TrailerRepository;
import com.mymovies.services.EntityInstanceService;
import com.mymovies.services.TrailerService;
import com.mymovies.web.dtos.TrailerDTO;
@Service


public class TrailerServiceImpl implements TrailerService {

	@Autowired
	TrailerRepository tr;
	
	@Autowired
	EntityInstanceService eis;

	@Override
	public List<Trailer> getAll() {
		return tr.findAll();
	}

	@Override
	public Trailer getById(long id) {
		return tr.findById(id).orElse(null);
	}

	@Override
	public Trailer create(TrailerDTO obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(long id) {
		tr.deleteById(id);
		
	}

	@Override
	public Trailer update(TrailerDTO obj) {
		return null;
		
	}

	@Override
	public List<TrailerDTO> getAllDTOs(List<Trailer> objs) {
		List<TrailerDTO> dtos = new ArrayList<TrailerDTO>();
		objs.forEach(el->{
			TrailerDTO dto = new TrailerDTO(el);
			dtos.add(dto);
		});
		
		return dtos;
	}

	@Override
	public TrailerDTO getSingleDTO(Trailer obj) {
		TrailerDTO dto = new TrailerDTO(obj);
		return dto;
	}



	
	
	

}
