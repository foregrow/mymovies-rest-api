package com.mymovies.services;

import java.util.ArrayList;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovies.models.Photo;
import com.mymovies.repositories.PhotoRepository;
import com.mymovies.web.dtos.PhotoDTO;
@Service
public class PhotoServiceImpl implements PhotoService {

	@Autowired
	PhotoRepository pr;
	
	@Autowired
	FactoryEntityService fe;

	@Override
	public List<Photo> getAll() {
		return pr.findAll();
	}

	@Override
	public Photo getById(long id) {
		return pr.findById(id).orElse(null);
	}

	@Override
	public Photo create(PhotoDTO obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(long id) {
		pr.deleteById(id);
		
	}

	@Override
	public void update(PhotoDTO obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PhotoDTO> getAllDTOs(List<Photo> objs) {
		List<PhotoDTO> dtos = new ArrayList<PhotoDTO>();
		objs.forEach(el->{
			PhotoDTO dto = new PhotoDTO(el);
			dtos.add(dto);
		});
		
		return dtos;
	}

	@Override
	public PhotoDTO getSingleDTO(Photo obj) {
		PhotoDTO dto = new PhotoDTO(obj);
		return dto;
	}

	
	
	

}
