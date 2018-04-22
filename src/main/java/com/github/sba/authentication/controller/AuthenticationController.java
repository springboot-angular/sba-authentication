package com.github.sba.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.sba.authentication.service.AuthenticationService;

@RestController
@RequestMapping(value = "/authentication", produces = "application/json")
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;

	@RequestMapping(method = RequestMethod.GET)
	public String get(@RequestParam(name = "login", required = true) String login,
			@RequestParam(name = "password", required = true) String password) {
		return authenticationService.authenticate(login, password);
	}

}
