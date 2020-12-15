package com.mymovies.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mymovies.authmodel.AuthenticationRequest;
import com.mymovies.authmodel.AuthenticationResponse;
import com.mymovies.services.UserService;
import com.mymovies.utils.JwtUtil;


@CrossOrigin(origins ="*",allowedHeaders = "*")
@RestController
public class AuthController {
	@Autowired
	private UserService us;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@RequestMapping(value ="/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		try {
			
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword())
			);
			
		}catch (BadCredentialsException e) {
			throw new Exception ("wrong input email/password", e);
		}
		final UserDetails userDetails = us
				.loadUserByUsername(authenticationRequest.getEmail());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		String role = "";
		for (GrantedAuthority authority : userDetails.getAuthorities())
			role = authority.getAuthority();
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt,role));
	}
	

}
