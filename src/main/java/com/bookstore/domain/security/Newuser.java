/**
 * 
 */
package com.bookstore.domain.security;

import java.io.Serializable;

/**
 * @author nikhil
 *
 */
public class Newuser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6743802623316065336L;
	
	private String username;
	private String email;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
