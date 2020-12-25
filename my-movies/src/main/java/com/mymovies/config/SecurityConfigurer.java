package com.mymovies.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.mymovies.enums.UserRole;
import com.mymovies.filter.JwtRequestFilter;
import com.mymovies.services.UserService;



@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserService us;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	private String ADMIN = UserRole.ADMIN.toString();
	private String USER = UserRole.USER.toString();
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(us);
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeRequests()
			.antMatchers("/authenticate").permitAll()
			.antMatchers("/api/users").permitAll()
			.antMatchers(HttpMethod.DELETE,"/api/users").hasAuthority(ADMIN)
			
			.antMatchers("/api/persons").hasAnyAuthority(ADMIN,USER)
			.antMatchers(HttpMethod.DELETE,"/api/persons").hasAuthority(ADMIN)
			.antMatchers(HttpMethod.PUT,"/api/persons").hasAuthority(ADMIN)
			.antMatchers(HttpMethod.POST,"/api/persons").hasAuthority(ADMIN)
			
			.antMatchers("/api/mts/movies").hasAnyAuthority(ADMIN,USER)
			.antMatchers("/api/mts/tvshows").hasAnyAuthority(ADMIN,USER)
			.antMatchers(HttpMethod.DELETE,"/api/mts").hasAuthority(ADMIN)
			.antMatchers(HttpMethod.PUT,"/api/mts").hasAuthority(ADMIN)
			.antMatchers(HttpMethod.POST,"/api/mts").hasAuthority(ADMIN)
			.anyRequest().authenticated();

		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		http.cors(); //za Access-Control-Allow-Origin error
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

}
