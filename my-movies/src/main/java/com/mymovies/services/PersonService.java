package com.mymovies.services;

import java.util.List;

import com.mymovies.models.Person;
import com.mymovies.web.dtos.PersonDTO;


public interface PersonService extends CrudService<Person, PersonDTO>, DTOService<Person, PersonDTO> {
	List<Person> findAllPersonsNotInMTS(long mtsid);
}
