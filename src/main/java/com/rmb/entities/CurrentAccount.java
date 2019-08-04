package com.rmb.entities;

import javax.persistence.Entity;

import com.rmb.Constants;

@Entity
public class CurrentAccount extends Account {

	public CurrentAccount(User user, double initialDeposit, String currency) {

		super(user, initialDeposit, currency);
		accountType = Constants.AccountType.current;
		minimumBalance = 100.0d;
		accountNumber = generateAccountNumber();
	}

	private CurrentAccount() {
	}
}
