package com.mymovies.services;

import org.springframework.web.multipart.MultipartFile;

import com.mymovies.models.Photo;
import com.mymovies.web.dtos.PhotoDTO;

public interface PhotoService extends CrudService<Photo, PhotoDTO>, DTOService<Photo, PhotoDTO> {

	Photo create(MultipartFile file,String entity, long id);
}
