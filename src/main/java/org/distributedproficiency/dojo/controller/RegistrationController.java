package org.distributedproficiency.dojo.controller;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.distributedproficiency.dojo.auth.DojoAuthConstants;
import org.distributedproficiency.dojo.domain.Registration;
import org.distributedproficiency.dojo.dto.InitiatedRegistrationResponse;
import org.distributedproficiency.dojo.dto.RegistrationRequest;
import org.distributedproficiency.dojo.services.RegistrationService;
import org.distributedproficiency.dojo.services.StudentAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	private Log log = LogFactory.getLog(RegistrationController.class);
	
	public RegistrationController() {
		super();
	}
	
	// TODO revisit the privacy of this when we expose the user to their registration flow 
	@PreAuthorize("isAuthenticated() and hasRole('"+DojoAuthConstants.AUTH_ROLE_ADMIN_NAME+"')")
	@RequestMapping(value="/registrations/all", method=RequestMethod.GET)
	public Collection<Registration> listRegistrations() {
		return registrationService.getAllRegistrations();
	}
	
	@PreAuthorize("isAuthenticated() and hasRole('"+DojoAuthConstants.AUTH_ROLE_ADMIN_NAME+"')")
	@RequestMapping(value="/registrations/{id}", method=RequestMethod.GET)
	public Registration getRegistration(@PathVariable("id") String id) {
		return registrationService.getRegistrationById(new Long(id));
	}
	
	@RequestMapping(value="/registrations", method=RequestMethod.POST)
	public InitiatedRegistrationResponse initiateRegistration() {
		return registrationService.initiateRegistration();
	}
	
	// anyone can upload a registration against a key
	@RequestMapping(value="/registrations/{key}", method=RequestMethod.PUT)
	public void commenceRegistration(@PathVariable("key") String key, @RequestBody RegistrationRequest request) throws StudentAlreadyExistsException {
		registrationService.registerPatient(key, request);
	}	
	
	// only admins can approve registrations
	@PreAuthorize("isAuthenticated() and hasRole('"+DojoAuthConstants.AUTH_ROLE_ADMIN_NAME+"')")
	@RequestMapping(value="/registrations/{id}/approve", method=RequestMethod.PUT)
	public void approveRegistrationStatus(@PathVariable("id") String id) {
		registrationService.approveRegistration(new Long(id));
	}
	
}
