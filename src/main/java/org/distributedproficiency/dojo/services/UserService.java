package org.distributedproficiency.dojo.services;

import org.distributedproficiency.dojo.auth.DojoUserRole;
import org.distributedproficiency.dojo.domain.User;
import org.distributedproficiency.dojo.dto.UserOverview;

import java.util.Collection;

public interface UserService {
	User createUserWithUsernameAndType(String username, String password, DojoUserRole role) throws UserAlreadyExistsException;
	User findUserByUsername(String username) throws UserNotFoundException;
	Collection<UserOverview> getAllUsers();
}
