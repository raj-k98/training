package com.trg.account.model;

public class SavingAccount extends Account {

	private static final double MINIMUM_BALANCE = 500;

	public SavingAccount(int accNo, Person accHolder, double balance) {
		super(accNo, accHolder, balance);
	}

	@Override
	public void withdraw(double amount) {

		if (getBalance() - amount < MINIMUM_BALANCE)
			System.out.println("Not possible to withdraw " + amount + " from balance " + getBalance()+"\nMinimum Balance requird: "+MINIMUM_BALANCE);
			
		else
			super.withdraw(amount);
	}

}
