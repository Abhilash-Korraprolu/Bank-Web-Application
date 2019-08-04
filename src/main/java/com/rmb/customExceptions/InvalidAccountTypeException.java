package com.rmb.customExceptions;

public class InvalidAccountTypeException extends RuntimeException {

	public InvalidAccountTypeException() {
	}

	public InvalidAccountTypeException(String s) {
		super(s);
	}
}
