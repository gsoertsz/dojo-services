package org.distributedproficiency.dojo.services;

public class KataNotFoundException extends Exception {

    public KataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public KataNotFoundException(String message) {
        super(message);
    }
}
