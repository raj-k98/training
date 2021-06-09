package com.trg.boot.handler;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.trg.boot.exceptions.EmployeeCreateException;
import com.trg.boot.exceptions.EmployeeNotFoundException;

@ControllerAdvice
public class EmployeeErrorHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<String> errors = ex.getBindingResult()
				                .getFieldErrors()
				                .stream()
				                .map(x -> x.getDefaultMessage())
				                .collect(Collectors.toList());
	
		Map<String,Object> errorMap=new LinkedHashMap<>();
		errorMap.put("ValidationErrors", errors);
		return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<?> abcd(EmployeeNotFoundException ex){
		
		Map<String,Object> errors=new LinkedHashMap<>();
		errors.put("error", "notfound");
		errors.put("message", ex.getMessage());
		errors.put("timeStamp", LocalDate.now());
		
		return new ResponseEntity<Object>(errors, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<?> abcd(NumberFormatException ex){
		
		Map<String,Object> errors=new LinkedHashMap<>();
		errors.put("error", "conversion");
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
