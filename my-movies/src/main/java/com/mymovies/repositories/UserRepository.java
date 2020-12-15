package com.mymovies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.mymovies.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
