package org.distributedproficiency.dojo.dto;

import io.swagger.annotations.ApiModel;

public class InitiatedRegistrationResponse {
	
	private Long registrationId;
	private String registrationKey;

	public InitiatedRegistrationResponse() {
		super();
	}

	public InitiatedRegistrationResponse(Long registrationId,
			String registrationKey) {
		super();
		this.registrationId = registrationId;
		this.registrationKey = registrationKey;
	}

	public Long getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Long registrationId) {
		this.registrationId = registrationId;
	}

	public String getRegistrationKey() {
		return registrationKey;
	}

	public void setRegistrationKey(String registrationKey) {
		this.registrationKey = registrationKey;
	}

}
