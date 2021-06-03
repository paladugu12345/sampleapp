package com.india.icicibank.exception;

public class ToAccountNumberNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ToAccountNumberNotFoundException(String message) {
		super(message);

	}

	public ToAccountNumberNotFoundException(String message, Throwable t) {
		super(message, t);

	}
}
