package com.traini8.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	// Exception handler for MethodArgumentNotValidException
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex){
		Map<String, String> resp = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName = ((FieldError)error).getField();
			String message = error.getDefaultMessage();
			resp.put(fieldName, message);
		});
		return new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);
	}
	
	 //Exception handler for HttpMessageNotReadableException
	@ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        String errorMessage = "Check your request format(studentCapacity, contactPhone & pincode should contain only digits and cann't be empty) if format is correct then your request is to long for these feilds.";
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
	
	// Exception handler for SQLSyntaxErrorException
	@ExceptionHandler(java.sql.SQLSyntaxErrorException.class)
    public ResponseEntity<String> handleSQLSyntaxErrorException(java.sql.SQLSyntaxErrorException ex) {
        String errorMessage = "Server isn't re-started yet!!! after changes are made, Re-start then server and try again : " + ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	// Exception handler for ConstraintViolationException
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Map<String, String>> handleConstraintViolationException(ConstraintViolationException ex) {
	    Map<String, String> resp = new HashMap<>();
	    ex.getConstraintViolations().forEach((violation) -> {
	        String fieldName = violation.getPropertyPath().toString();
	        String message = violation.getMessage();
	        resp.put(fieldName, message);
	    });
	    return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
	}
}
