package com.rmb.customExceptions;

public class InsufficientFundsException extends RuntimeException {

	public InsufficientFundsException() {
	}

	public InsufficientFundsException(String s) {
		super(s);
	}
}
