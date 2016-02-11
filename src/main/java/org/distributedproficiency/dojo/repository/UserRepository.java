package org.distributedproficiency.dojo.repository;

import org.distributedproficiency.dojo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("select u from User u where u.username = ?1")
	public User findUserByUsername(String username);
}
