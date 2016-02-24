package org.distributedproficiency.dojo.services;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import org.distributedproficiency.dojo.auth.DojoUserRole;
import org.distributedproficiency.dojo.domain.User;
import org.distributedproficiency.dojo.dto.UserOverview;
import org.distributedproficiency.dojo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

    @Override
	public Collection<UserOverview> getAllUsers() {
        return userRepository.findAll().stream()
                .map(
                        (User u) -> { return toOverviewFrom(u); }
                )
                .collect(Collectors.toList());
	}

    private UserOverview toOverviewFrom(User u) {
        UserOverview uo = new UserOverview();
        uo.setUsername(u.getUsername());
        uo.setUserId(u.getId());
        uo.setUserRole(u.getUserRole());
        uo.setCreatedDateTime(u.getCreatedDateTime());
        return uo;
    }

	@Override
	public User createUserWithUsernameAndType(String username, String password, DojoUserRole role) throws UserAlreadyExistsException {
		if (username == null) throw new IllegalArgumentException("Username was null");

		User existingUser = userRepository.findUserByUsername(username);
		if (existingUser != null) throw new UserAlreadyExistsException("User with username ["+username+"] already exists");
		
		User newUser = User.create(username, password, role);
		userRepository.save(newUser);
		newUser.setCreatedDateTime(new Date());
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
