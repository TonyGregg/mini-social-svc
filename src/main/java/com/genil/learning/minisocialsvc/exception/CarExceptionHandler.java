package com.genil.learning.minisocialsvc.exception;

import configs.ValidationErrorConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;
import java.util.stream.Collectors;

/**
 * Created by Antony Genil on 4/27/2020 at 8:20 AM, for project - mini-social-svc.
 **/
@ControllerAdvice
@Slf4j
public class CarExceptionHandler extends ResponseEntityExceptionHandler {
@Autowired private ValidationErrorConfig validationErrorConfig;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        return handleInputBindingError(ex.getBindingResult());
    }

    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleInputBindingError(ex.getBindingResult());
    }

    private ResponseEntity<Object> handleInputBindingError(BindingResult bindingResult) {
        String errors = bindingResult.getAllErrors().stream()
                .map(fieldError -> validationErrorConfig.getMessages().get(fieldError.getDefaultMessage()))
                .collect(Collectors.joining(", "));
        CarErrorResponse<ErrorResponse> carErrorResponse = buildCarErrorResponse(errors, HttpStatus.BAD_REQUEST.value(),
                new BindException(bindingResult));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(carErrorResponse);

    }

    private CarErrorResponse<ErrorResponse> buildCarErrorResponse(String errorMessage, int errorCode, Exception ex) {
        log.error(ex.getMessage(), ex);
        CarErrorResponse carErrorResponse = new CarErrorResponse();
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(errorCode);
        errorResponse.setErrorMessage(errorMessage);

        carErrorResponse.setError(errorResponse);

        return carErrorResponse;
    }

    /**
     * Handle data exception and set the HTTP status code to 503.
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<CarErrorResponse> handleDataAccessException(DataAccessException ex) {
        CarErrorResponse carErrorResponse = buildCarErrorResponse("Data access exception has occurred - "
                + ex.getMessage(), HttpStatus.SERVICE_UNAVAILABLE.value(), ex);
        return new ResponseEntity<>(carErrorResponse, HttpStatus.SERVICE_UNAVAILABLE);
    }


    /**
     * Handle all SQL exceptions
     * @param sqlException
     * @return
     */
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<CarErrorResponse> handleSqlException(SQLException sqlException) {
        CarErrorResponse carErrorResponse = buildCarErrorResponse("SQL exception has occurred - "
                + sqlException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), sqlException);
        return new ResponseEntity<>(carErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
