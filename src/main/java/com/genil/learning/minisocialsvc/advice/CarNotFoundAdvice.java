package com.genil.learning.minisocialsvc.advice;

import com.genil.learning.minisocialsvc.exception.CarNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Antony Genil Gregory on 1/4/2020 9:17 PM
 * For project : mini-social-svc
 **/
@ControllerAdvice
public class CarNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(CarNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String carNotFoundHandler(CarNotFoundException ex) {
        final String message = ex.getMessage();
        return message;
    }
}
