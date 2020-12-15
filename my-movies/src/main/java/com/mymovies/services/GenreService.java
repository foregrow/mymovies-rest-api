package com.mymovies.services;

import com.mymovies.models.Genre;
import com.mymovies.web.dtos.GenreDTO;


public interface GenreService extends CrudService<Genre, GenreDTO>, DTOService<Genre, GenreDTO> {

}
