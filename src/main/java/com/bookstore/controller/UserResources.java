package com.bookstore.controller;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.config.SecurityUtility;
import com.bookstore.domain.security.Newuser;
import com.bookstore.domain.security.Role;
import com.bookstore.domain.security.User;
import com.bookstore.domain.security.UserRole;
import com.bookstore.service.UserService;

@RestController
@RequestMapping("/user")
public class UserResources {

	@Autowired
	private UserService userResources;

	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	public ResponseEntity newUserPost(HttpServletRequest request, @RequestBody Newuser newuser) {
		
		String userName = newuser.getUsername();
		String userEmail = newuser.getEmail();
		if (userResources.findByUsername(userName) != null) {
			return new ResponseEntity("emailExists", HttpStatus.BAD_REQUEST);
			
		}
		if (userResources.findByEmail(userEmail) != null) {
			return new ResponseEntity("emailExists", HttpStatus.BAD_REQUEST);
			
		}

		User user = new User();
		user.setUsername(userName);
		user.setEmail(userEmail);
		String password = SecurityUtility.randomPassword();
		String encrptedPassword = SecurityUtility.passwordEncoder().encode(password);
		user.setPassword(encrptedPassword);
		Role role = new Role();
		role.setRoleId(1);
		role.setName("ROLE_NAME");
		Set<UserRole> userRole = new HashSet<>();
		userRole.add(new UserRole(user, role));
		User u = userResources.createUser(user, userRole);
		return new ResponseEntity("User Added SuccessFully", HttpStatus.OK);

	}

}
