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
	FactoryEntityService fe;
	
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
	public void update(PersonDTO obj) {
		if(obj!=null) {
			Person person = getById(obj.getId());
			if(person!=null) {
				person.setFirstName(obj.getFirstName());
				person.setLastName(obj.getLastName());
				person.setBio(obj.getBio());
				pr.save(person);
			}	
		}
		
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

	
	
	
	
	

}
