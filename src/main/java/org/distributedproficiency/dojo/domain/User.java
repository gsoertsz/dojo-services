/* 
 **
 ** Copyright 2014, Jules White
 **
 ** 
 */
package org.distributedproficiency.dojo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User /*implements UserDetails*/ {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -49075115110864095L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	
	public static User create(String username) {
		User u = new User(username);
		//u.setUserRole(null);
		return u;
	}

	private String username;

	private String password;
	
	public User() {
		super();
	}

	@SuppressWarnings("unchecked")
	private User(String username) {
		this(username, null);
	}

	private User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}
}
