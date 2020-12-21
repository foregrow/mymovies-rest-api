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

import com.mymovies.models.Season;
import com.mymovies.services.SeasonService;
import com.mymovies.web.dtos.SeasonDTO;



@RestController
@CrossOrigin(origins ="*",allowedHeaders = "*")
@RequestMapping(value="api/seasons")
public class SeasonController {
	

	@Autowired
	SeasonService ss;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {
		List<Season> seasons = ss.getAll();	
		List<SeasonDTO> dtos = ss.getAllDTOs(seasons);		
		
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getById(@PathVariable long id){
		Season obj = ss.getById(id);
		
		if(obj == null)
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
		SeasonDTO dto = ss.getSingleDTO(obj);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<?> save(@RequestBody SeasonDTO dto){

		Season obj = ss.create(dto);
		if(obj==null)
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
		SeasonDTO responseObj = ss.getSingleDTO(obj);
		return new ResponseEntity<>(responseObj, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<?> update(@RequestBody SeasonDTO dto){
		Season obj = ss.update(dto);
		if(obj==null)
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		SeasonDTO responseObj = ss.getSingleDTO(obj);
		return new ResponseEntity<>(responseObj, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable long id){
		Season obj = ss.getById(id);
		if (obj != null){
			ss.deleteById(id);
			List<Season> objs = ss.getAll();
			List<SeasonDTO> dtos = ss.getAllDTOs(objs);
			
			return new ResponseEntity<>(dtos, HttpStatus.OK);
		} else		
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
	}


}
