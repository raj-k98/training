package com.trg.bank.exceptions;

public class InvalidDepositException extends RuntimeException {
	
	public InvalidDepositException(String msg) {
		super(msg);
	}

}
