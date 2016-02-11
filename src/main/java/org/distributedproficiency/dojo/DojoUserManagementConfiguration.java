package org.distributedproficiency.dojo;

import org.distributedproficiency.dojo.auth.DojoUserManagementService;
import org.distributedproficiency.dojo.services.UserService;
import org.distributedproficiency.dojo.services.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DojoUserManagementConfiguration {

	public DojoUserManagementConfiguration() {
		// TODO Auto-generated constructor stub
	}
	
	@Bean()
	public DojoUserManagementService getImpatientUserManagementService() {
		return new DojoUserManagementService();
	}
	
	@Bean
	public UserService getUserService() {
		return new UserServiceImpl();
	}

}
