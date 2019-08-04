package com.rmb.customExceptions;

public class InvalidAccountException extends RuntimeException {

	public InvalidAccountException() {
	}

	public InvalidAccountException(String s) {
		super(s);
	}
}
