package com.login.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	 User findByUsername(String username);
}
