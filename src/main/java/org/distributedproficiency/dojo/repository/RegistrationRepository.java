package org.distributedproficiency.dojo.repository;

import org.distributedproficiency.dojo.domain.Registration;
import org.distributedproficiency.dojo.domain.RegistrationStatus;
import org.distributedproficiency.dojo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
	@Query("select r from Registration r where r.student = ?1")
	Registration findOneByPatient(Student patient);
	
	@Query("update Registration r set r.status = ?2 where r.id = ?1")
	void updateRegistrationStatus(Long id, RegistrationStatus targetStatus);
	
	@Query("select r from Registration r where r.registrationKey = ?1")
	Registration findByRegistrationKey(String key);
}
