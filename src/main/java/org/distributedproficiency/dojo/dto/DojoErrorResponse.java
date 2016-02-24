package org.distributedproficiency.dojo.dto;

import org.springframework.http.HttpStatus;

public class DojoErrorResponse {
    private int statusCode;
    private String message;

    public DojoErrorResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
