package com.trg.boot.rest.exceptions;

public class EmployeeNotFoundException extends RuntimeException {

	public EmployeeNotFoundException(String message) {
		super(message);
	}

}
