package com.eshop.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException ex) {
       ErrorInfo error =new ErrorInfo(1404, ex.getMessage(), ex.getLocalizedMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<?> handleUserAlreadyExistException(UserAlreadyExistException ex) {
        ErrorInfo error =new ErrorInfo(1405, ex.getMessage(), ex.getLocalizedMessage());
        return new ResponseEntity<>(error, HttpStatus.ALREADY_REPORTED);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleUserException(Exception ex) {
        ErrorInfo error =new ErrorInfo(1500, ex.getMessage(), ex.getLocalizedMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}