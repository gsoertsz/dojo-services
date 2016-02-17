package org.distributedproficiency.dojo.controller;

import java.util.Collection;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.distributedproficiency.dojo.domain.Registration;
import org.distributedproficiency.dojo.dto.InitiatedRegistrationResponse;
import org.distributedproficiency.dojo.dto.RegistrationRequest;
import org.distributedproficiency.dojo.services.RegistrationService;
import org.distributedproficiency.dojo.services.StudentAlreadyExistsException;
import org.distributedproficiency.dojo.swagger.DojoApiDocoWorthy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "registration", description = "registration service")
@RestController
@DojoApiDocoWorthy
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	private Log log = LogFactory.getLog(RegistrationController.class);
	
	public RegistrationController() {
		super();
	}

    @ApiOperation(value = "/all")
	@RequestMapping(value="/registrations/all", method=RequestMethod.GET)
	public Collection<Registration> listRegistrations() {
		return registrationService.getAllRegistrations();
	}
	
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

	@RequestMapping(value="/registrations/{id}/approve", method=RequestMethod.PUT)
	public void approveRegistrationStatus(@PathVariable("id") String id) {
		registrationService.approveRegistration(new Long(id));
	}
	
}
