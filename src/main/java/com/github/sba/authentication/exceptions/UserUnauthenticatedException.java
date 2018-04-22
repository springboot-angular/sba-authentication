package com.github.sba.authentication.exceptions;

public class UserUnauthenticatedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserUnauthenticatedException(String message) {
		super(message);
	}

	public UserUnauthenticatedException(String message, Throwable cause) {
		super(message);
	}

}
