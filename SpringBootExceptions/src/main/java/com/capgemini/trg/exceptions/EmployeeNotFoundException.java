package com.capgemini.trg.exceptions;

public class EmployeeNotFoundException extends RuntimeException {
	
	private String operation;

	public EmployeeNotFoundException(String operation ,String message) {
		super(message);
		this.operation=operation;
	
	}

	public String getOperation() {
		return operation;
	}

}
