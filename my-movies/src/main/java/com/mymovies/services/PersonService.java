package com.mymovies.services;

import com.mymovies.models.Person;
import com.mymovies.web.dtos.PersonDTO;


public interface PersonService extends CrudService<Person, PersonDTO>, DTOService<Person, PersonDTO> {

}
