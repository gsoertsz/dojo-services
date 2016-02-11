package org.distributedproficiency.dojo.services;

public class StudentAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7323637206939056485L;

	public StudentAlreadyExistsException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
