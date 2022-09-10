package com.eshop.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpServerErrorException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException ex) {
        ErrorInfo error = new ErrorInfo(1404, ex.getMessage(), ex.getLocalizedMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<?> handleUserAlreadyExistException(UserAlreadyExistException ex) {
        ErrorInfo error = new ErrorInfo(1405, ex.getMessage(), ex.getLocalizedMessage());
        return new ResponseEntity<>(error, HttpStatus.ALREADY_REPORTED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleUserException(Exception ex) {
        ErrorInfo error = new ErrorInfo(1500, ex.getMessage(), ex.getLocalizedMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        ErrorInfo error = new ErrorInfo(1600, "Validation Error", errors);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}