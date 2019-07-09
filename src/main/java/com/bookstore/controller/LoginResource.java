package com.bookstore.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.service.UserService;

@RestController
public class LoginResource {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/token")
	public Map<String,String>  token(HttpSession httpSession,HttpServletRequest httpServletRequest){
		
		//System.out.println(httpServletRequest.getRemoteHost());
		String remoteHost = httpServletRequest.getRemoteHost();
		int portNumber = httpServletRequest.getRemotePort();
		////System.out.println("remoteHost"+remoteHost +"portNumber:" + portNumber);
		//System.out.println("RemoteAddr"+httpServletRequest.getRemoteAddr());
		return Collections.singletonMap("token",httpSession.getId());
		
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/checkSession")
	public Map<String,String> checkSession() {
		//return new 	ResponseEntity("Session Active",HttpStatus.OK);
		return Collections.singletonMap("token","ok working session");
	}
}
