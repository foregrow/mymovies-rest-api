package com.mymovies.services;

import com.mymovies.models.Trailer;
import com.mymovies.web.dtos.TrailerDTO;

public interface TrailerService extends CrudService<Trailer, TrailerDTO> , DTOService<Trailer, TrailerDTO>{

}
