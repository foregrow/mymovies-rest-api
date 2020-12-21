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

import com.mymovies.models.Episode;
import com.mymovies.services.EpisodeService;
import com.mymovies.web.dtos.EpisodeDTO;



@RestController
@CrossOrigin(origins ="*",allowedHeaders = "*")
@RequestMapping(value="api/episodes")
public class EpisodeController {
	

	@Autowired
	EpisodeService es;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {
		List<Episode> episodes = es.getAll();	
		List<EpisodeDTO> dtos = es.getAllDTOs(episodes);		
		
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getById(@PathVariable long id){
		Episode obj = es.getById(id);
		
		if(obj == null)
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
		EpisodeDTO dto = es.getSingleDTO(obj);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<?> save(@RequestBody EpisodeDTO dto){

		Episode obj = es.create(dto);
		if(obj==null)
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
		EpisodeDTO responseObj = es.getSingleDTO(obj);
		return new ResponseEntity<>(responseObj, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<?> update(@RequestBody EpisodeDTO dto){
		Episode obj = es.update(dto);
		if(obj==null)
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		EpisodeDTO responseObj = es.getSingleDTO(obj);
		return new ResponseEntity<>(responseObj, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable long id){
		Episode obj = es.getById(id);
		if (obj != null){
			es.deleteById(id);
			List<Episode> objs = es.getAll();
			List<EpisodeDTO> dtos = es.getAllDTOs(objs);
			
			return new ResponseEntity<>(dtos, HttpStatus.OK);
		} else		
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
	}


}
