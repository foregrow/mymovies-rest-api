package com.mymovies.services;

import java.util.List;



public interface DTOService<T,S> {

	List<S> getAllDTOs(List<T> objs);
	
	S getSingleDTO(T obj);
}
