package com.rmb.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Transaction {

	@Id
	@GeneratedValue
	private long id;
	@NotBlank
	private String name;
	@NotBlank
	private String amount;
	private double balance;
	private final LocalDateTime timeStamp;
	@ManyToOne
	@JoinColumn(name = "Account_Transaction")
	private Account account;

	public Transaction(Account account, @NotBlank String name, @NotBlank String amount, double balance) {

		this.amount = amount;
		this.balance = balance;
		this.name = name;
		timeStamp = LocalDateTime.now();
		this.account = account;
	}

	private Transaction() {
		timeStamp = LocalDateTime.now();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
