package org.distributedproficiency.dojo.services;

import org.distributedproficiency.dojo.common.DojoSomethingNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UserNotFoundException extends DojoSomethingNotFoundException {

	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserNotFoundException(String message) {
		super(message);
	}

}
