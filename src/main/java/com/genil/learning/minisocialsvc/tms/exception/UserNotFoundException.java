package com.genil.learning.minisocialsvc.tms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Antony Genil Gregory on 1/7/2020 7:19 PM
 * For project : mini-social-svc
 *
 **/

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        this("User Not found");
    }
    public UserNotFoundException(String message) {
        this(message, null);
    }
    public UserNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
