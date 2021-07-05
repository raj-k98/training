package com.trg.account.model;

import com.trg.account.exceptions.WithdrawException;

public class SavingAccount extends Account {

	private static final double MINIMUM_BALANCE = 500;

	public SavingAccount(int accNo, Person accHolder, double balance) {
		super(accNo, accHolder, balance);
	}

	@Override
	public void withdraw(double amount) throws WithdrawException {

		if (getBalance() - amount < MINIMUM_BALANCE)
			
			throw new WithdrawException("Not possible to withdraw " + amount + " from balance " + getBalance()
					+ "\nMinimum Balance required: " + MINIMUM_BALANCE);
		

			double newBalance = getBalance() - amount;
			setBalance(newBalance);

	}

}


