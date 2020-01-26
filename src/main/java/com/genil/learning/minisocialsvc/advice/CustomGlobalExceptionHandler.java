package com.genil.learning.minisocialsvc.advice;

import com.genil.learning.minisocialsvc.exception.CarErrorResponse;
import com.genil.learning.minisocialsvc.exception.CarNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Antony Genil Gregory on 1/5/2020 8:34 PM
 * For project : mini-social-svc
 **/
@ControllerAdvice
@Slf4j
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", status.value());

        //Get all errors
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("errors", errors);

        return new ResponseEntity<>(body, headers, status);

    }

    @Override
    protected ResponseEntity<Object> handleBindException(BindException bindException, HttpHeaders headers, HttpStatus status,
                                                         WebRequest request) {
        log.error("Error");
        String errors = bindException.getAllErrors()
                .stream()
                .map(fieldError-> fieldError.getDefaultMessage())
                .collect(Collectors.joining( ","));

        CarErrorResponse carErrorResponse = new CarErrorResponse();
        carErrorResponse.setError(errors);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(carErrorResponse);
    }
}
