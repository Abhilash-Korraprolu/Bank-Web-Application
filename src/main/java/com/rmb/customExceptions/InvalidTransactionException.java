package com.rmb.customExceptions;

public class InvalidTransactionException extends RuntimeException{
	
	public InvalidTransactionException() {
	}

	public InvalidTransactionException(String s) {
		super(s);
	}

}
