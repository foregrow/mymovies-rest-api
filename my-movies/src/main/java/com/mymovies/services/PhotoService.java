package com.mymovies.services;

import com.mymovies.models.Photo;
import com.mymovies.web.dtos.PhotoDTO;

public interface PhotoService extends CrudService<Photo, PhotoDTO>, DTOService<Photo, PhotoDTO> {

}
