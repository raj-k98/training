package com.trg.account.model;

public class Account {

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

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void deposit(double amount) {
		balance = balance + amount;
	}

	public void withdraw(double amount) {
		balance -= amount;
	}
}
