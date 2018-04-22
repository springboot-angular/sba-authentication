package com.github.sba.authentication.advice;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.github.sba.authentication.exceptions.UserNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger LOG = Logger.getLogger(GlobalExceptionHandler.class);

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({ UserNotFoundException.class })
	@ResponseBody
	public ErrorResponse handleNotFoundException(HttpServletRequest req, Exception ex) {
		LOG.debug(ex.getMessage(), ex);
		return new ErrorResponse(req.getRequestURL().toString(), ex);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ErrorResponse handleException(HttpServletRequest req, Exception ex) {
		LOG.fatal(ex.getMessage(), ex);
		return new ErrorResponse(req.getRequestURL().toString(), ex);
	}

}
