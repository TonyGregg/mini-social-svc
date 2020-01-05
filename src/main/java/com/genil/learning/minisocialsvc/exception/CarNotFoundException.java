package com.genil.learning.minisocialsvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Antony Genil on 12/19/19 at 18 54 for mini-social-svc
 **/
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException() {
        this("Could not find any cars !");
    }
    public CarNotFoundException(Long id) {
        this("Could not find any cars with the id "+id);
    }
    public CarNotFoundException(String message) {
        this(message, null);
    }
    public CarNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
