package com.trg.account.model;

import com.trg.account.exceptions.WithdrawException;

public class CurrentAccount extends Account {

	private static final double OVERDRAFT_LIMIT = 5000;

	public CurrentAccount(int accNo, Person accHolder, double balance) {
		super(accNo, accHolder, balance);
	}

	@Override
	public void withdraw(double amount) throws WithdrawException  {

		if (getBalance() + 5000 < amount)
			throw   new WithdrawException("Not possible to withdraw " + amount + " from balance " + getBalance()
					+ "\nThis withdrawal exceeds overdraft limit " + OVERDRAFT_LIMIT);
		
			double newBalance = getBalance() - amount;
			setBalance(newBalance);
	}

}
