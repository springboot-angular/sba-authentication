package com.github.sba.authentication.exceptions;

public class PermissionDeniedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PermissionDeniedException(String message) {
		super(message);
	}

	public PermissionDeniedException(String message, Throwable cause) {
		super(message);
	}

}
