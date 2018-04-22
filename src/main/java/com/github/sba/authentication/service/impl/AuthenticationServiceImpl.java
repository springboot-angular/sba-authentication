package com.github.sba.authentication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.sba.authentication.Token;
import com.github.sba.authentication.entity.User;
import com.github.sba.authentication.exceptions.UserUnauthenticatedException;
import com.github.sba.authentication.service.AuthenticationService;
import com.github.sba.authentication.service.TokenService;
import com.github.sba.authentication.service.UserService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private TokenService tokenService;

	@Autowired
	private UserService userService;

	@Transactional(readOnly = true)
	@Override
	public Token authenticate(String login, String password) {
		User user = userService.get(login);

		if (!user.getPassword().equals(password))
			throw new UserUnauthenticatedException("Senha inválida");

		return tokenService.generate(user);
	}

}
