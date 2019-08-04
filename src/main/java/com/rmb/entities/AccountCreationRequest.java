package com.rmb.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class AccountCreationRequest {

	@Id
	@NotBlank
	@Pattern(regexp = "\\d+(\\.\\d{1,2})?")
	private String initialDeposit;
	@NotBlank
	private String accountType;
	@NotBlank
	private String currencyType;

	public double getInitialDeposit() {

		return Double.valueOf(initialDeposit);
	}

	public void setInitialDeposit(String initialDeposit) {
		this.initialDeposit = initialDeposit;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currency) {
		this.currencyType = currency;
	}

}
