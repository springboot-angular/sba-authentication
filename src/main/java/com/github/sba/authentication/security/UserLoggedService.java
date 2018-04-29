package com.github.sba.authentication.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.sba.authentication.entity.User;
import com.github.sba.authentication.service.UserService;

@Service
public class UserLoggedService {

	@Autowired
	private HttpServletRequest httpRequest;

	@Autowired
	private UserService userService;

	public User get() {
		return userService.get(httpRequest.getUserPrincipal().getName());
	}

}
