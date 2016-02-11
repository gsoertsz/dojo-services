package org.distributedproficiency.dojo.services;

import java.util.Collection;

import org.distributedproficiency.dojo.domain.Registration;
import org.distributedproficiency.dojo.dto.InitiatedRegistrationResponse;
import org.distributedproficiency.dojo.dto.RegistrationRequest;

public interface RegistrationService {
	
	public InitiatedRegistrationResponse initiateRegistration();
	
	public void registerPatient(String key, RegistrationRequest r) throws StudentAlreadyExistsException;
	
	public Collection<Registration> getAllRegistrations();
	
	public Registration getRegistrationById(Long id);
	
	public void approveRegistration(Long id);

	public void invalidateMissedRegistrations();
}
