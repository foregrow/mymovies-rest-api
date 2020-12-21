package com.mymovies.services;

import java.util.ArrayList;




import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mymovies.models.Photo;
import com.mymovies.models.User;
import com.mymovies.repositories.UserRepository;
import com.mymovies.utils.PasswordBCrypt;
import com.mymovies.web.dtos.UserDTO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository ur;
	
	@Autowired
	FactoryEntityService fe;

	@Autowired
	PhotoService ps;
	
	@Override
	public List<User> getAll() {
		return ur.findAll();
	}

	@Override
	public User getById(long id) {
		return ur.findById(id).orElse(null);
	}

	@Override
	public User create(UserDTO obj) {
		if(obj!=null) {
			User user = (User) fe.getEntityByDTO(obj);
			user.setEmail(obj.getEmail());
			user.setPassword(PasswordBCrypt.hashPassword(obj.getPassword()));
			user.setUserRole(obj.getUserRole());
			return ur.save(user);
		}
		return null;
	}

	@Override
	public void deleteById(long id) {
		ur.deleteById(id);
		
	}

	@Override
	public User update(UserDTO obj) {
		if(obj.getPhoto()!=null) {
			User user = findByEmail(obj.getEmail());
			Photo photo = ps.create(obj.getPhoto());
			if(user!=null&&photo!=null) {
				user.setPhoto(photo);
				return ur.save(user);
			}
		}
		return null;
		
	}
	
	@Override
	public User findByEmail(String email) {
		return ur.findByEmail(email);
	}
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = ur.findByEmail(userName);

		if(user==null)
			return new org.springframework.security.core.userdetails.User("","", null);
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		grantedAuthorities.add(new SimpleGrantedAuthority(user.getUserRole().toString()));
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(), grantedAuthorities);
	}

	@Override
	public List<UserDTO> getAllDTOs(List<User> objs) {
		List<UserDTO> dtos = new ArrayList<UserDTO>();
		objs.forEach(el->{
			UserDTO dto = new UserDTO(el);
			dto.setMoviesTvShows(el.getMoviesTvShows());
			dtos.add(dto);
		});
		
		return dtos;
	}

	@Override
	public UserDTO getSingleDTO(User obj) {
		UserDTO dto = new UserDTO(obj);
		dto.setMoviesTvShows(obj.getMoviesTvShows());
		return dto;
	}

	

	

}
