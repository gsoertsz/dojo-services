package org.distributedproficiency.dojo.controller;

import java.security.Principal;

import org.distributedproficiency.dojo.auth.DojoAuthConstants;
import org.distributedproficiency.dojo.auth.DojoUserRole;
import org.distributedproficiency.dojo.domain.User;
import org.distributedproficiency.dojo.services.UserAlreadyExistsException;
import org.distributedproficiency.dojo.services.UserNotFoundException;
import org.distributedproficiency.dojo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	public UserController() {
		// TODO Auto-generated constructor stub
	}
	
	// client checks this end point to ensure they are logged in
	// if they cannot be authenticated then they either haven't logged in
	// or they don't exist.
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public String getAuthority(Principal p) throws UserNotFoundException {
		User u = userService.findUserByUsername(p.getName());
		return u.getUserRole().toString();
	}
	
	@PreAuthorize("isAuthenticated() and hasRole('"+DojoAuthConstants.AUTH_ROLE_SUPERUSER_NAME+"')")
	@RequestMapping(value="/users/admin/{username}", method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public void createAdminUser(@PathVariable("username") String username) throws UserAlreadyExistsException {
		userService.createUserWithUsernameAndType(username, DojoUserRole.ADMIN);
	}
}
