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

import com.mymovies.enums.MovieTvShowType;
import com.mymovies.models.MovieTvShow;
import com.mymovies.services.MovieTvShowService;
import com.mymovies.web.dtos.MovieTvShowDTO;



@RestController
@CrossOrigin(origins ="*",allowedHeaders = "*")
@RequestMapping(value="api/mts")
public class MovieTvShowController {
	

	@Autowired
	MovieTvShowService mtss;
	
	int MOVIE = MovieTvShowType.MOVIE.ordinal();
	int TV_SHOW = MovieTvShowType.TV_SHOW.ordinal();
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {
		List<MovieTvShow> moviestvshows = mtss.getAll();	
		List<MovieTvShowDTO> dtos = mtss.getAllDTOs(moviestvshows);		
		
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@RequestMapping(value="/movies",method = RequestMethod.GET)
	public ResponseEntity<?> getAllMovies() {
		List<MovieTvShow> moviestvshows = mtss.findAllByType(MovieTvShowType.MOVIE);	
		List<MovieTvShowDTO> dtos = mtss.getAllDTOs(moviestvshows);		
		
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@RequestMapping(value="/tvshows",method = RequestMethod.GET)
	public ResponseEntity<?> getAllTVShows() {
		List<MovieTvShow> moviestvshows = mtss.findAllByType(MovieTvShowType.TV_SHOW);	
		List<MovieTvShowDTO> dtos = mtss.getAllDTOs(moviestvshows);		
		
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@RequestMapping(value="/namecontains/{name}",method = RequestMethod.GET)
	public ResponseEntity<?> getAllByNameContains(@PathVariable String name) {

		List<MovieTvShow> moviestvshows = mtss.findAllByNameContains(name);	
		List<MovieTvShowDTO> dtos = mtss.getAllDTOs(moviestvshows);		
		System.out.println(dtos.size());
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	
	@RequestMapping(value={"/{id}","/{id}/{type}"}, method=RequestMethod.GET)
	public ResponseEntity<?> getById(@PathVariable long id,@PathVariable(required = false) String type){
		
		MovieTvShow obj = mtss.getById(id);
		if(obj == null)
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
		MovieTvShowDTO dto = mtss.getSingleDTO(obj);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<?> save(@RequestBody MovieTvShowDTO dto){

		MovieTvShow obj = mtss.create(dto);
		if(obj==null)
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
		MovieTvShowDTO responseObj = mtss.getSingleDTO(obj);
		return new ResponseEntity<>(responseObj, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<?> update(@RequestBody MovieTvShowDTO dto){
		MovieTvShow obj = mtss.update(dto);
		if(obj==null)
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		MovieTvShowDTO responseObj = mtss.getSingleDTO(obj);
		return new ResponseEntity<>(responseObj, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable long id){
		MovieTvShow obj = mtss.getById(id);
		
		if (obj != null){
			MovieTvShowType type = obj.getType();
			mtss.deleteById(id);
			List<MovieTvShow> objs = mtss.findAllByType(type);
			List<MovieTvShowDTO> dtos = mtss.getAllDTOs(objs);
			
			return new ResponseEntity<>(dtos, HttpStatus.OK);
		} else		
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
	}


}
