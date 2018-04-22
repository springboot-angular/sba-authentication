package com.github.sba.authentication.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.sba.authentication.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Transactional(readOnly = true)
	@Override
	public String authenticate(String login, String password) {
		return "Teste Ok";
	}

}
