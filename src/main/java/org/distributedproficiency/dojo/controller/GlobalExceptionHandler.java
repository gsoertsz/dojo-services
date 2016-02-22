package org.distributedproficiency.dojo.controller;

import org.distributedproficiency.dojo.common.DojoSomethingAlreadyExistsException;
import org.distributedproficiency.dojo.common.DojoSomethingNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class GlobalExceptionHandler {

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Not Found!")
    @ExceptionHandler(DojoSomethingNotFoundException.class)
    public void handleNotFoundExceptions() {
        ; // annotations handle this.
    }

    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "Already exists!")
    @ExceptionHandler(DojoSomethingAlreadyExistsException.class)
    public void handleAlreadyExistsException() {
        ; // annotations handle this
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal error!")
    @ExceptionHandler(RuntimeException.class)
    public void handleGenericError() {
        ; // annotations handle this
    }

}
