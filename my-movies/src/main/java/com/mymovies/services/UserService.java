package com.mymovies.services;

import org.springframework.security.core.userdetails.UserDetailsService;


import com.mymovies.models.User;
import com.mymovies.web.dtos.UserDTO;

public interface UserService extends CrudService<User, UserDTO>, UserDetailsService, DTOService<User, UserDTO> {

	User findByEmail(String email);
	
}
