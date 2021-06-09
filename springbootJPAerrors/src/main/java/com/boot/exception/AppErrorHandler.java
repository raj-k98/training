package com.boot.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppErrorHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(EmployeeNotFoundException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), new ArrayList<String>());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<String> errors = ex.getBindingResult()
				                .getFieldErrors()
				                .stream()
				                .map(x -> x.getDefaultMessage())
				                .collect(Collectors.toList());
		ErrorDetails errorDetails = new ErrorDetails("Data Not valid", errors);

		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
}
