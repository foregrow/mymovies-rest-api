package com.mymovies.services;

import java.util.List;


public interface CrudService<T,S> {

	List<T> getAll();
	
	T getById(long id);
	
	T create(S obj);
	
	void deleteById(long id);
	
	void update(S obj);
}
