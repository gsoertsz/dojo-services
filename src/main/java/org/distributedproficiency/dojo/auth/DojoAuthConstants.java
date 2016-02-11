package org.distributedproficiency.dojo.auth;

import org.distributedproficiency.dojo.domain.User;

public class DojoAuthConstants {
	public static final String AUTH_ROLE_PATIENT_NAME = "ROLE_PATIENT";
	public static final String AUTH_ROLE_ADMIN_NAME = "ROLE_ADMIN";
	public static final String AUTH_ROLE_SUPERUSER_NAME = "ROLE_SUPERUSER";
	
	public static final String IMPATIENT_DEFAULT_PASSWORD = "imimpatient";
	
	public static final User SUPER_USER = User.create("superuser", IMPATIENT_DEFAULT_PASSWORD, DojoUserRole.SUPERUSER);

	private DojoAuthConstants() {
		// TODO Auto-generated constructor stub
	}

}
