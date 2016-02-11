package org.distributedproficiency.dojo.auth;

import org.distributedproficiency.dojo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class DojoUserManagementService implements UserDetailsService {
	
	@Autowired
	private UserService userService;

	public DojoUserManagementService() {
		super();
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {		
		try { 
			UserDetails u = (username.equals(DojoAuthConstants.SUPER_USER.getUsername()))
					? DojoAuthConstants.SUPER_USER
							: userService.findUserByUsername(username);						
			
			if (u == null) throw new UsernameNotFoundException("No user with username ["+username+"]");
			
			return u;
		} catch (Throwable t) {
			throw new UsernameNotFoundException("Error locating user", t);
		}
	}

}
