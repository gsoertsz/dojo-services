/* 
 **
 ** Copyright 2014, Jules White
 **
 ** 
 */
package org.distributedproficiency.dojo.domain;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.distributedproficiency.dojo.auth.DojoUserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -49075115110864095L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private DojoUserRole userRole;
	
	public static User create(String username, String password,
			DojoUserRole role) {
		User u = new User(username, password);
		u.setUserRole(role);
		return u;
	}
	
	private String password;
	
	private String username;
	
	public User() {
		super();
	}

	@SuppressWarnings("unchecked")
	private User(String username, String password) {
		this(username, password, Collections.EMPTY_LIST);
	}

	private User(String username, String password,
			Collection<GrantedAuthority> authorities) {
		super();
		this.username = username;
		this.password = password;
	}

	public Collection<GrantedAuthority> getAuthorities() {
		return AuthorityUtils.createAuthorityList(userRole.toString());
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public DojoUserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(DojoUserRole userRole) {
		this.userRole = userRole;
	}
}
