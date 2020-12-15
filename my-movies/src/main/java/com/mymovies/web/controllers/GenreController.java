package com.mymovies.web.controllers;



import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mymovies.models.Genre;
import com.mymovies.services.GenreService;
import com.mymovies.web.dtos.GenreDTO;



@RestController
@CrossOrigin(origins ="*",allowedHeaders = "*")
@RequestMapping(value="api/genres")
public class GenreController {
	

	@Autowired
	GenreService gs;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {
		List<Genre> genres = gs.getAll();	
		List<GenreDTO> dtos = gs.getAllDTOs(genres);		
		
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getById(@PathVariable long id){
		Genre obj = gs.getById(id);
		
		if(obj == null)
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
		GenreDTO dto = gs.getSingleDTO(obj);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<?> save(@RequestBody GenreDTO dto){

		Genre obj = gs.create(dto);
		if(obj==null)
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
		GenreDTO responseObj = gs.getSingleDTO(obj);
		return new ResponseEntity<>(responseObj, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable long id){
		Genre obj = gs.getById(id);
		if (obj != null){
			gs.deleteById(id);
			List<Genre> objs = gs.getAll();
			List<GenreDTO> dtos = gs.getAllDTOs(objs);
			
			return new ResponseEntity<>(dtos, HttpStatus.OK);
		} else		
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
	}


}
