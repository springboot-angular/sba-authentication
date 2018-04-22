package com.github.sba.authentication.exceptions;

public class UserNotNullException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserNotNullException(String message) {
		super(message);
	}

	public UserNotNullException(String message, Throwable cause) {
		super(message);
	}

}