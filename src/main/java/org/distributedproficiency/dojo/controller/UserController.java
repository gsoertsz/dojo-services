package org.distributedproficiency.dojo.controller;

import java.security.Principal;
import java.util.Collection;

import io.swagger.annotations.Api;
import org.distributedproficiency.dojo.auth.DojoUserRole;
import org.distributedproficiency.dojo.auth.DojoUserRoleUtils;
import org.distributedproficiency.dojo.domain.User;
import org.distributedproficiency.dojo.dto.UserCreateRequest;
import org.distributedproficiency.dojo.dto.UserCreatedResponse;
import org.distributedproficiency.dojo.dto.UserOverview;
import org.distributedproficiency.dojo.services.UserAlreadyExistsException;
import org.distributedproficiency.dojo.services.UserNotFoundException;
import org.distributedproficiency.dojo.services.UserService;
import org.distributedproficiency.dojo.swagger.DojoApiDocoWorthy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@DojoApiDocoWorthy
public class UserController {
	
	@Autowired
	private UserService userService;
	
	public UserController() {
		// TODO Auto-generated constructor stub
	}

    @RequestMapping(value="/users", method=RequestMethod.GET)
    @PreAuthorize("hasRole('"+DojoUserRoleUtils.ADMIN_ROLE_NAME+"')")
    public Collection<UserOverview> getAllUsers() {
        return userService.getAllUsers();

    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED)
    @PreAuthorize("hasRole('" + DojoUserRoleUtils.ADMIN_ROLE_NAME + "')")
    public UserCreatedResponse createUser(@RequestBody UserCreateRequest createRequest) {
        User u = userService.createUserWithUsernameAndType(createRequest.getUsername(), createRequest.getPassword(), DojoUserRole.USER);
        UserCreatedResponse resp = new UserCreatedResponse(u.getId(), u.getUsername(), new Long(u.getCreatedDateTime().getTime()));
        return resp;
    }

    @RequestMapping(value = "/admin/users", method=RequestMethod.POST)
    @PreAuthorize("hasRole('" + DojoUserRoleUtils.SUPERUSER_ROLE_NAME + "')")
    public @ResponseBody UserCreatedResponse createAdminUser(@RequestBody UserCreateRequest createRequest) {
        User u = userService.createUserWithUsernameAndType(createRequest.getUsername(), createRequest.getPassword(), DojoUserRole.ADMIN);
        UserCreatedResponse resp = new UserCreatedResponse(u.getId(), u.getUsername(), new Long(u.getCreatedDateTime().getTime()));
        return resp;
    }
}
