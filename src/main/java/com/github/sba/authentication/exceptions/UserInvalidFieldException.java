package com.github.sba.authentication.exceptions;

public class UserInvalidFieldException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserInvalidFieldException(String message) {
		super(message);
	}

	public UserInvalidFieldException(String message, Throwable cause) {
		super(message, cause);
	}
}
