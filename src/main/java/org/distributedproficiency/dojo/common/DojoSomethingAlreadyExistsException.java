package org.distributedproficiency.dojo.common;

public class DojoSomethingAlreadyExistsException extends RuntimeException {

    public DojoSomethingAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public DojoSomethingAlreadyExistsException(String message) {
        super(message);
    }
}
