package com.trg.bank;

import com.trg.bank.exceptions.AccountCreateException;
import com.trg.bank.exceptions.InsufficientBalnceException;
import com.trg.bank.exceptions.InvalidDepositException;

public class SavingsAccount  implements Account{
	
	private int accountNo;
	private String name;
	private float balance;
	
	static final float MINIMUM_BALANCE = 1000.0f;
	
	public SavingsAccount(int accountNo, String name, float balance) throws AccountCreateException  {
		super();
		
		if(balance < MINIMUM_BALANCE)
			throw new AccountCreateException("Acconut cannot be created with initial amount " + balance +" Minimum amount accepted is "+MINIMUM_BALANCE);
		this.accountNo = accountNo;
		this.name = name;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public float getBalance() {
		return balance;
	}

	@Override
	public void deposit(float amount) {
		
		if(amount < 100) {
			throw new InvalidDepositException(amount + " for deposit not accepted. Minimum deposit is 100");
		}
		
		balance=balance+amount;
		
	}

	@Override
	public void withdraw(float amount) throws InsufficientBalnceException {
		if(balance - amount < MINIMUM_BALANCE)
			throw new InsufficientBalnceException("Balance not sufficient to withdraw "+ amount);
		
		balance = balance - amount;
	}

	@Override
	public String toString() {
		return "AccountNo=" + accountNo + ", name=" + name + ", balance=" + balance ;
	}
	
	

}
