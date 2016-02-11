package org.distributedproficiency.dojo.auth;

public enum DojoUserRole {
	PATIENT(DojoAuthConstants.AUTH_ROLE_PATIENT_NAME),
	ADMIN(DojoAuthConstants.AUTH_ROLE_ADMIN_NAME), 
	SUPERUSER(DojoAuthConstants.AUTH_ROLE_SUPERUSER_NAME);
	
	private String roleString;
	
	private DojoUserRole(String roleStr) {
		this.roleString = roleStr;
	}
	
	@Override
	public String toString() {
		return roleString;
	}
}
