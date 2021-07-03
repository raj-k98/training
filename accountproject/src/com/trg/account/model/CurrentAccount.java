package com.trg.account.model;

public class CurrentAccount extends Account {

	private static final double OVERDRAFT_LIMIT = 5000;

	public CurrentAccount(int accNo, Person accHolder, double balance) {
		super(accNo, accHolder, balance);
	}

	@Override
	public void withdraw(double amount) {

		if (getBalance() + 5000 < amount)
			System.out.println("Not possible to withdraw " + amount + " from balance " + getBalance()+
					"\nThis withdrawal exceeds overdraft limit "+OVERDRAFT_LIMIT);
		else
			super.withdraw(amount);
	}

}
