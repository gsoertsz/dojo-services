package org.distributedproficiency.dojo.dto;

public class RegistrationRequest {
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String primaryPhone;
	
	public RegistrationRequest() {
		super();
	}

	public RegistrationRequest(String username, String firstName,
			String lastName, String email, String primaryPhone) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.primaryPhone = primaryPhone;
	}

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPrimaryPhone() {
		return primaryPhone;
	}

	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
