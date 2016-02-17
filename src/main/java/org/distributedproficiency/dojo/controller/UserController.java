package org.distributedproficiency.dojo.controller;

import java.security.Principal;

import io.swagger.annotations.Api;
import org.distributedproficiency.dojo.domain.User;
import org.distributedproficiency.dojo.services.UserAlreadyExistsException;
import org.distributedproficiency.dojo.services.UserNotFoundException;
import org.distributedproficiency.dojo.services.UserService;
import org.distributedproficiency.dojo.swagger.DojoApiDocoWorthy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@DojoApiDocoWorthy
@Api(value = "/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	public UserController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value="/users/admin/{username}", method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public void createAdminUser(@PathVariable("username") String username) throws UserAlreadyExistsException {
		userService.createUserWithUsernameAndType(username);
	}
}
