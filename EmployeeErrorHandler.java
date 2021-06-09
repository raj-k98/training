package com.trg.boot.handler;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.trg.boot.exceptions.EmployeeCreateException;
import com.trg.boot.exceptions.EmployeeNotFoundException;

@ControllerAdvice
public class EmployeeErrorHandler {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<?> abcd(EmployeeNotFoundException ex){
		
		Map<String,Object> errors=new LinkedHashMap<>();
		errors.put("error", "notfound");
		errors.put("message", ex.getMessage());
		errors.put("timeStamp", LocalDate.now());
		
		return new ResponseEntity<Object>(errors, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmployeeCreateException.class)
	public ResponseEntity<?> handleEmployeeDataError(EmployeeCreateException ex){
		
		Map<String,Object> errors=new LinkedHashMap<>();
		errors.put("error", "SaveFailed");
		errors.put("message", ex.getMessage());
		errors.put("timeStamp", LocalDate.now());
		
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}

}
