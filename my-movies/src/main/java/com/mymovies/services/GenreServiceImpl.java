package com.mymovies.services;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovies.models.Genre;
import com.mymovies.repositories.GenreRepository;
import com.mymovies.web.dtos.GenreDTO;
@Service
public class GenreServiceImpl implements GenreService {

	@Autowired
	GenreRepository gr;
	
	@Autowired
	FactoryEntityService fe;

	@Override
	public List<Genre> getAll() {
		return gr.findAll();
	}
	

	@Override
	public Genre getById(long id) {
		return gr.findById(id).orElse(null);
	}

	@Override
	public Genre create(GenreDTO obj) {
		if(obj!=null) {
			Genre genre = (Genre) fe.getEntityByDTO(obj);
			genre.setType(obj.getType());
			
			return gr.save(genre);
		}
		return null;
	}

	@Override
	public void deleteById(long id) {
		gr.deleteById(id);
		
	}

	@Override
	public void update(GenreDTO obj) {
		
		
	}


	@Override
	public List<GenreDTO> getAllDTOs(List<Genre> objs) {
		List<GenreDTO> dtos = new ArrayList<GenreDTO>();
		objs.forEach(el->{
			GenreDTO dto = new GenreDTO(el);
			dto.setMoviesTvShows(el.getMoviesTvShows());
			dtos.add(dto);
		});
		
		return dtos;
	}


	@Override
	public GenreDTO getSingleDTO(Genre obj) {
		GenreDTO dto = new GenreDTO(obj);
		dto.setMoviesTvShows(obj.getMoviesTvShows());
		return dto;
	}
	
	
	
	

}
