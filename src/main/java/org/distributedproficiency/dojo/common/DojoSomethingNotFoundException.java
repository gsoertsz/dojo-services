package org.distributedproficiency.dojo.common;

public abstract class DojoSomethingNotFoundException extends RuntimeException {

    public DojoSomethingNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DojoSomethingNotFoundException(String message) {
        super(message);
    }
}
