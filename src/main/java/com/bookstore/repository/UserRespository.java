package com.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.domain.security.User;

@Repository
public interface UserRespository extends JpaRepository<User, Long>{
	
	User findByUsername(String username);

	User findByEmail(String email);

	List<User> findAll();
	
	  	

}
