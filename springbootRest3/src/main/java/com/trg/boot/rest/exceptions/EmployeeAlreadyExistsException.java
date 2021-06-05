package com.trg.boot.rest.exceptions;

public class EmployeeAlreadyExistsException extends RuntimeException {

	public EmployeeAlreadyExistsException(String message) {
		super(message);
	}
	
}
