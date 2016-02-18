package org.distributedproficiency.dojo.services;

public class KataTagAlreadyExists extends Exception {

    public KataTagAlreadyExists(String message, Throwable cause) {
        super(message, cause);
    }

    public KataTagAlreadyExists(String message) {
        super(message);
    }
}
