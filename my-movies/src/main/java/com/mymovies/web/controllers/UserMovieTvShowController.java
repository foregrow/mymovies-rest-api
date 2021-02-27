package com.mymovies.web.controllers;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mymovies.MyMoviesApplication;
import com.mymovies.models.UserMovieTvShow;
import com.mymovies.services.MovieTvShowService;
import com.mymovies.services.UserMovieTvShowService;
import com.mymovies.web.dtos.UserMovieTvShowDTO;



@RestController
@CrossOrigin(origins ="*",allowedHeaders = "*")
@RequestMapping(value="api/usermts")
public class UserMovieTvShowController {
	

	@Autowired
	UserMovieTvShowService umtss;
	
	@Autowired
	MovieTvShowService mtss;
	
	@Value("${param.newRating}")
	 private static String newRating;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {
		List<UserMovieTvShow> usermoviestvshows = umtss.getAll();	
		List<UserMovieTvShowDTO> dtos = umtss.getAllDTOs(usermoviestvshows);		
		
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getById(@PathVariable long id){
		UserMovieTvShow obj = umtss.getById(id);
		
		if(obj == null)
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
		UserMovieTvShowDTO dto = umtss.getSingleDTO(obj);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@RequestMapping(value="/emailmts/{email}/{mtsid}", method=RequestMethod.GET)
	public ResponseEntity<?> getByEmailAndMTSId(@PathVariable String email,@PathVariable long mtsid){
		UserMovieTvShow obj = umtss.findByUserEmailAndMovieTvShowId(email, mtsid);
		if(obj == null)
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
		UserMovieTvShowDTO dto = umtss.getSingleDTO(obj);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	/*@RequestMapping(value="/user-email/{email}", method=RequestMethod.GET)
	public ResponseEntity<?> getByEmail(@PathVariable String email){
		UserMovieTvShow obj = umtss.findByUserEmail(email);
		if(obj == null)
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
		UserMovieTvShowDTO dto = umtss.getSingleDTO(obj);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}*/
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<?> save(@RequestBody UserMovieTvShowDTO dto){

		UserMovieTvShow obj = umtss.create(dto);
		if(obj==null)
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
		UserMovieTvShowDTO responseObj = umtss.getSingleDTO(obj);
		return new ResponseEntity<>(responseObj, HttpStatus.OK);
	}
	
	@RequestMapping(value="/user-details/{email}/{mtsId}/{newRating}/{param}/{wlParam}", method=RequestMethod.GET)
	public ResponseEntity<?> userRating(@PathVariable String email, @PathVariable long mtsId, @PathVariable int newRating,
			@PathVariable String param,@PathVariable boolean wlParam){
		umtss.updateDetails(email, mtsId, newRating,param,wlParam);

		if(param.equals("newRating"))
			mtss.calculateMTSAvgRating(newRating, mtsId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<?> update(@RequestBody UserMovieTvShowDTO dto){
		UserMovieTvShow obj = umtss.update(dto);
		if(obj==null)
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		UserMovieTvShowDTO responseObj = umtss.getSingleDTO(obj);
		return new ResponseEntity<>(responseObj, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable long id){
		UserMovieTvShow obj = umtss.getById(id);
		if (obj != null){
			umtss.deleteById(id);
			List<UserMovieTvShow> objs = umtss.getAll();
			List<UserMovieTvShowDTO> dtos = umtss.getAllDTOs(objs);
			
			return new ResponseEntity<>(dtos, HttpStatus.OK);
		} else		
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
	}


}
