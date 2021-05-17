package com.trg.bank;

import com.trg.bank.exceptions.InsufficientBalnceException;

public interface Account {
	
	void deposit(float amount);
	void withdraw(float amount) throws InsufficientBalnceException ;

}
