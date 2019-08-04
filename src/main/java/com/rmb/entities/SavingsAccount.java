package com.rmb.entities;

import javax.persistence.Entity;

import com.rmb.Constants;

@Entity
public class SavingsAccount extends Account {

	public SavingsAccount(User user, double initialDeposit, String currency) {

		super(user, initialDeposit, currency);
		accountType = Constants.AccountType.savings;
		minimumBalance = 0;
		accountNumber = generateAccountNumber();
	}

	private SavingsAccount() {

	}
}
