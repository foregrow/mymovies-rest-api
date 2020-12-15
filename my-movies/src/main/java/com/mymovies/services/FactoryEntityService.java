package com.mymovies.services;


import org.springframework.stereotype.Service;

import com.mymovies.models.Episode;
import com.mymovies.models.Genre;
import com.mymovies.models.MovieTvShow;
import com.mymovies.models.Person;
import com.mymovies.models.PersonMovieTvShow;
import com.mymovies.models.Photo;
import com.mymovies.models.Season;
import com.mymovies.models.Trailer;
import com.mymovies.models.User;
import com.mymovies.models.UserMovieTvShow;
import com.mymovies.web.dtos.EpisodeDTO;
import com.mymovies.web.dtos.GenreDTO;
import com.mymovies.web.dtos.MovieTvShowDTO;
import com.mymovies.web.dtos.PersonDTO;
import com.mymovies.web.dtos.PersonMovieTvShowDTO;
import com.mymovies.web.dtos.PhotoDTO;
import com.mymovies.web.dtos.SeasonDTO;
import com.mymovies.web.dtos.TrailerDTO;
import com.mymovies.web.dtos.UserDTO;
import com.mymovies.web.dtos.UserMovieTvShowDTO;


@Service
public class FactoryEntityService {

	public Object getEntityByDTO(Object obj){
		if(obj!=null) {
			if(obj instanceof EpisodeDTO)
				return new Episode();
			else if(obj instanceof GenreDTO)
				return new Genre();
			else if(obj instanceof MovieTvShowDTO)
				return new MovieTvShow();
			else if(obj instanceof PersonDTO)
				return new Person();
			else if(obj instanceof PersonMovieTvShowDTO)
				return new PersonMovieTvShow();
			else if(obj instanceof PhotoDTO)
				return new Photo();
			else if(obj instanceof SeasonDTO)
				return new Season();
			else if(obj instanceof TrailerDTO)
				return new Trailer();
			else if(obj instanceof UserDTO)
				return new User();
			else if(obj instanceof UserMovieTvShowDTO)
				return new UserMovieTvShow();
		}
		return null;
		
	}
	
	/*public Object getDTOByEntity(List<?> objs){
		if(objs!=null && !objs.isEmpty()) {
			Object firstEl = objs.get(0);
			if(firstEl instanceof Episode)
				return new EpisodeDTO();
			else if(firstEl instanceof Genre)
				return new GenreDTO();
			else if(firstEl instanceof MovieTvShow)
				return new MovieTvShowDTO();
			else if(firstEl instanceof Person)
				return new PersonDTO();
			else if(firstEl instanceof PersonMovieTvShow)
				return new PersonMovieTvShowDTO();
			else if(firstEl instanceof Photo)
				return new PhotoDTO();
			else if(firstEl instanceof Season)
				return new SeasonDTO();
			else if(firstEl instanceof Trailer)
				return new TrailerDTO();
			else if(firstEl instanceof User)
				return new UserDTO();
			else if(firstEl instanceof UserMovieTvShow)
				return new UserMovieTvShowDTO();
		}
		return null;
		
	}*/
}

	
