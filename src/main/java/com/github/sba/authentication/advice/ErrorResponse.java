package com.github.sba.authentication.advice;

public class ErrorResponse {

	private String url;
	private String exception;
	private String cause;
	private String message;

	public ErrorResponse() {

	}

	public ErrorResponse(String url, Exception ex) {
		this.url = url;
		this.exception = ex.getClass().getSimpleName();
		this.cause = ex.getCause().getClass().getSimpleName();
		this.message = ex.getLocalizedMessage();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
