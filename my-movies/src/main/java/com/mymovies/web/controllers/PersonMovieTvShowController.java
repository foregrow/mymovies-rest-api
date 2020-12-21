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

import com.mymovies.models.PersonMovieTvShow;
import com.mymovies.services.PersonMovieTvShowService;
import com.mymovies.web.dtos.PersonMovieTvShowDTO;



@RestController
@CrossOrigin(origins ="*",allowedHeaders = "*")
@RequestMapping(value="api/personmts")
public class PersonMovieTvShowController {
	

	@Autowired
	PersonMovieTvShowService pmtss;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {
		List<PersonMovieTvShow> personmts = pmtss.getAll();	
		List<PersonMovieTvShowDTO> dtos = pmtss.getAllDTOs(personmts);		
		
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getById(@PathVariable long id){
		PersonMovieTvShow obj = pmtss.getById(id);
		
		if(obj == null)
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
		PersonMovieTvShowDTO dto = pmtss.getSingleDTO(obj);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<?> save(@RequestBody PersonMovieTvShowDTO dto){

		PersonMovieTvShow obj = pmtss.create(dto);
		if(obj==null)
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
		PersonMovieTvShowDTO responseObj = pmtss.getSingleDTO(obj);
		return new ResponseEntity<>(responseObj, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<?> update(@RequestBody PersonMovieTvShowDTO dto){
		PersonMovieTvShow obj = pmtss.update(dto);
		if(obj==null)
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		PersonMovieTvShowDTO responseObj = pmtss.getSingleDTO(obj);
		return new ResponseEntity<>(responseObj, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable long id){
		PersonMovieTvShow obj = pmtss.getById(id);
		if (obj != null){
			pmtss.deleteById(id);
			List<PersonMovieTvShow> objs = pmtss.getAll();
			List<PersonMovieTvShowDTO> dtos = pmtss.getAllDTOs(objs);
			
			return new ResponseEntity<>(dtos, HttpStatus.OK);
		} else		
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
	}


}
