package org.distributedproficiency.dojo.services;

import org.distributedproficiency.dojo.domain.User;

public interface UserService {
	User createUserWithUsernameAndType(String username) throws UserAlreadyExistsException;
	User findUserByUsername(String username) throws UserNotFoundException;
}
