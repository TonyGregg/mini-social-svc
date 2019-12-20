package com.genil.learning.minisocialsvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Antony Genil on 12/19/19 at 18 54 for mini-social-svc
 **/
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        this("Resource not found!");
    }
    public ResourceNotFoundException(String message) {
        this(message, null);
    }
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
