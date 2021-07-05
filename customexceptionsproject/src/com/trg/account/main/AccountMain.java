package com.trg.account.main;

import com.trg.account.exceptions.WithdrawException;
import com.trg.account.model.Account;
import com.trg.account.model.CurrentAccount;
import com.trg.account.model.Person;
import com.trg.account.model.SavingAccount;

public class AccountMain {

	public static void main(String args[]) {

		Account account = new SavingAccount(111, new Person("John", 34), 1000);

		System.out.println("Balance Original:"+account.getBalance());

		try {

			account.withdraw(600);

			System.out.println("Withdraw successful. Balance after withdraw: " + account.getBalance());

		} catch (WithdrawException e) {

			System.out.println(e.getMessage());
			// e.printStackTrace();
		}

		System.out.println("Thank You");

	}

}
