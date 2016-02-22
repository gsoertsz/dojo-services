package org.distributedproficiency.dojo.controller;

import java.security.Principal;

import io.swagger.annotations.Api;
import org.distributedproficiency.dojo.domain.User;
import org.distributedproficiency.dojo.dto.UserCreateRequest;
import org.distributedproficiency.dojo.dto.UserCreatedResponse;
import org.distributedproficiency.dojo.services.UserAlreadyExistsException;
import org.distributedproficiency.dojo.services.UserNotFoundException;
import org.distributedproficiency.dojo.services.UserService;
import org.distributedproficiency.dojo.swagger.DojoApiDocoWorthy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserCreatedResponse createUser(@RequestBody UserCreateRequest createRequest) {
        User u = userService.createUserWithUsernameAndType(createRequest.getUsername());
        UserCreatedResponse resp = new UserCreatedResponse(u.getId(), u.getUsername(), new Long(u.getCreatedDateTime().getTime()));
        return resp;
    }
}
