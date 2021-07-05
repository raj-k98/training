package com.trg.account.model;

import com.trg.account.exceptions.WithdrawException;

abstract public class Account {

	private int accNo;
	private Person accHolder;
	private double balance;

	public Account(int accNo, Person accHolder, double balance) {
		super();
		this.accNo = accNo;
		this.accHolder = accHolder;
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	protected void setBalance(double balance) {
		this.balance = balance;
	}

	public void deposit(double amount) {
		balance = balance + amount;
	}

	abstract public void withdraw(double amount) throws WithdrawException;
}
