package com.trg.account.main;

import com.trg.account.model.Account;
import com.trg.account.model.CurrentAccount;
import com.trg.account.model.Person;
import com.trg.account.model.SavingAccount;

public class AccountMain {
	
	public static void main(String args[]) {
		
		Account account= new SavingAccount(111, new Person("John",34), 13000);
		
		System.out.println(account.getBalance());
		
		account.withdraw(18500);
		System.out.println(account.getBalance());
	}

}
