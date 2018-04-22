package com.github.sba.authentication.service;

import com.github.sba.authentication.Token;

public interface AuthenticationService {

	Token authenticate(String login, String password);

}
