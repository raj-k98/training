package com.trg.emp.boot.exceptions.handlers;

import java.time.LocalDateTime;
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

import com.capgemini.trg.exceptions.DuplicateEmployeeException;
import com.capgemini.trg.exceptions.EmployeeNotFoundException;
import com.capgemini.trg.exceptions.EmptyDataException;

@ControllerAdvice
public class ApplicationErrorHandler extends ResponseEntityExceptionHandler  {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<String> errorList= 
				ex.getBindingResult()
					.getFieldErrors()
					.stream()
					.map(fe->fe.getDefaultMessage())
					.collect(Collectors.toList());
		
		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("DataError", "Problems in Data received");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("errors", errorList);
		
		return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(DuplicateEmployeeException.class)
	public ResponseEntity<?> handleDuplicateEntity(DuplicateEmployeeException ex) {

		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("error", "Creation Failed");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());

		return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmptyDataException.class)
	public ResponseEntity<?> handleEmptyData(EmptyDataException ex) {
		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("error", "EmptyData");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());

		return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<?> handleMissingEmployee(EmployeeNotFoundException ex) {

		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("error", ex.getOperation() + " failed");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());

		return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
	}

}
