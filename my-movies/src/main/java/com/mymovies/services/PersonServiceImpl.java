package com.mymovies.services;

import java.util.ArrayList;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovies.models.Person;
import com.mymovies.repositories.PersonRepository;
import com.mymovies.web.dtos.PersonDTO;
@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepository pr;
	
	@Autowired
	EntityInstanceService fe;
	
	@Override
	public List<Person> getAll() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	@Override
	public Person getById(long id) {
		// TODO Auto-generated method stub
		return pr.findById(id).orElse(null);
	}

	@Override
	public Person create(PersonDTO obj) {
		if(obj!=null) {
			Person p = (Person) fe.getEntityByDTO(obj);
			p.setFirstName(obj.getFirstName());
			p.setLastName(obj.getLastName());
			p.setBio(obj.getBio());
			p.setBornDate(obj.getBornDate());
			p.setDiedDate(obj.getDiedDate());
			
			return pr.save(p);
		}
		return null;
	}

	@Override
	public void deleteById(long id) {
		pr.deleteById(id);
		
	}

	@Override
	public Person update(PersonDTO obj) {
		if(obj!=null) {
			Person person = getById(obj.getId());
			if(person!=null) {
				person.setFirstName(obj.getFirstName());
				person.setLastName(obj.getLastName());
				person.setBio(obj.getBio());
				person.setBornDate(obj.getBornDate());
				person.setDiedDate(obj.getDiedDate());
				return pr.save(person);
			}	
		}
		return null;
		
	}

	@Override
	public List<PersonDTO> getAllDTOs(List<Person> objs) {
		List<PersonDTO> dtos = new ArrayList<PersonDTO>();
		objs.forEach(el->{
			PersonDTO dto = new PersonDTO(el);
			dto.setMoviesTvShows(el.getMoviesTvShows());
			dto.setPhotos(el.getPhotos());
			dtos.add(dto);
		});
		
		return dtos;
	}

	@Override
	public PersonDTO getSingleDTO(Person obj) {
		PersonDTO dto = new PersonDTO(obj);
		dto.setMoviesTvShows(obj.getMoviesTvShows());
		dto.setPhotos(obj.getPhotos());
		return dto;
	}

	@Override
	public List<Person> findAllPersonsNotInMTS(long mtsid) {
		return pr.findAllPersonsNotInMTS(mtsid);
	}

	@Override
	public List<Person> findAllByIdIsNot(long mtsid) {
		return pr.findAllByIdIsNot(mtsid);
	}


	
	
	
	
	

}
