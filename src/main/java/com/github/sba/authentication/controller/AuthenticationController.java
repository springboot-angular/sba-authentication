package com.github.sba.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.sba.authentication.Token;
import com.github.sba.authentication.entity.User;
import com.github.sba.authentication.service.AuthenticationService;

@RestController
@RequestMapping(value = "/authentication", produces = "application/json")
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;

	@RequestMapping(method = RequestMethod.POST)
	public Token get(@RequestBody User user) {
		return authenticationService.authenticate(user.getEmail(), user.getPassword());
	}

}
