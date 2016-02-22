package org.distributedproficiency.dojo.services;

import org.distributedproficiency.dojo.common.DojoSomethingAlreadyExistsException;

public class UserAlreadyExistsException extends DojoSomethingAlreadyExistsException {

	public UserAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserAlreadyExistsException(String message) {
		super(message);
	}

}
