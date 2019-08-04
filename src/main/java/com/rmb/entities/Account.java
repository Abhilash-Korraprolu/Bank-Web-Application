package com.rmb.entities;

import java.time.LocalDateTime;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.rmb.Constants;
import com.rmb.customExceptions.InsufficientFundsException;
import com.rmb.customExceptions.InvalidAccountTypeException;

@Entity
public abstract class Account {

	@Id
	@Column(length = 20)
	protected String accountNumber;
	protected String accountType;
	private double balance;
	protected double minimumBalance;
	private String currency;
	private final LocalDateTime accountCreationTimeStamp;
	private LocalDateTime accountClosingTimeStamp;

	private String status;

	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	List<Transaction> transactions;

	@ManyToOne
	@JoinColumn(name = "UserPno")
	private User user;

	public Account(User user, double initialDeposit, String currency) {

		if (initialDeposit < minimumBalance)
			throw new InsufficientFundsException("Insufficient initial deposit for the account type");

		this.user = user;
		balance = initialDeposit;
		this.currency = currency;
		accountCreationTimeStamp = LocalDateTime.now();
		status = Constants.Status.ACTIVE;
	}

	public Account() {
		accountCreationTimeStamp = LocalDateTime.now();
	}

	protected String generateAccountNumber() {

		int accountNumberLength = 13;
		String userPno = user.getPno();
		String lastTwoDigitsOfPno = userPno.substring(userPno.length() - 2);
		String accountTypeCode;

		if (accountType.equals(Constants.AccountType.savings))
			accountTypeCode = Constants.AccountTypeCode.savings;

		else if (accountType.equals(Constants.AccountType.current))
			accountTypeCode = Constants.AccountTypeCode.current;

		else
			throw new InvalidAccountTypeException();

		int threeDigitRandomNumber = 100 + (int) (Math.random() * 899);
		int partialAccountNumberLength = (Constants.CountryCode.Sweden + accountTypeCode + lastTwoDigitsOfPno
				+ threeDigitRandomNumber).length();
		int remainingDigits = accountNumberLength - partialAccountNumberLength;
		String zeroes = String.valueOf((int) Math.pow(10, remainingDigits));
		zeroes = zeroes.substring(1);

		return Constants.CountryCode.Sweden + accountTypeCode + lastTwoDigitsOfPno + zeroes + threeDigitRandomNumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {

		if (balance < minimumBalance)
			throw new InsufficientFundsException();

		else
			this.balance = balance;
	}

	public double getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public LocalDateTime getAccountCreationTimeStamp() {
		return accountCreationTimeStamp;
	}

	public LocalDateTime getAccountClosingTimeStamp() {
		return accountClosingTimeStamp;
	}

	public void setAccountClosingTimeStamp(LocalDateTime accountClosingTimeStamp) {
		this.accountClosingTimeStamp = accountClosingTimeStamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
