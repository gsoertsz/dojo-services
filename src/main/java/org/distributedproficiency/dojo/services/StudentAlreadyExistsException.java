package org.distributedproficiency.dojo.services;

import org.distributedproficiency.dojo.common.DojoSomethingAlreadyExistsException;
import org.distributedproficiency.dojo.common.DojoSomethingNotFoundException;

public class StudentAlreadyExistsException extends DojoSomethingAlreadyExistsException {

	private static final long serialVersionUID = -7323637206939056485L;

	public StudentAlreadyExistsException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
