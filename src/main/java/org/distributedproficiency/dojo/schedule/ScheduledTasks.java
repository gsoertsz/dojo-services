package org.distributedproficiency.dojo.schedule;

import org.distributedproficiency.dojo.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
	
	@Autowired
	private RegistrationService registrationService;
	
	public ScheduledTasks() {
		// TODO Auto-generated constructor stub
	}
	
	@Scheduled(fixedRate=10000)
	public void markRegistrationsAsMissed() {
		registrationService.invalidateMissedRegistrations();
	}

}
