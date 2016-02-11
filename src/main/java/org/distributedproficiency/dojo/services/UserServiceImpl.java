package org.distributedproficiency.dojo.services;

import java.util.Collection;

import org.distributedproficiency.dojo.auth.DojoAuthConstants;
import org.distributedproficiency.dojo.auth.DojoUserRole;
import org.distributedproficiency.dojo.domain.User;
import org.distributedproficiency.dojo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	public Collection<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User createUserWithUsernameAndType(String username, DojoUserRole userRole) throws UserAlreadyExistsException {
		if (username == null) throw new IllegalArgumentException("Username was null");
		
		User existingUser = userRepository.findUserByUsername(username);
		if (existingUser != null) throw new UserAlreadyExistsException("User with username ["+username+"] already exists");
		
		User newUser = User.create(username, DojoAuthConstants.IMPATIENT_DEFAULT_PASSWORD, userRole);
		userRepository.save(newUser);
		return newUser;
	}

	@Override
	public User findUserByUsername(String username)
			throws UserNotFoundException {
		User u = userRepository.findUserByUsername(username);
		if (u == null) throw new UserNotFoundException(username + " not found");
		
		return u;
	}

}
