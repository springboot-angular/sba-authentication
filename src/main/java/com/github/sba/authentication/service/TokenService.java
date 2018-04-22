package com.github.sba.authentication.service;

import com.github.sba.authentication.Token;
import com.github.sba.authentication.entity.User;

public interface TokenService {
	public Token generate(User user);
	public String getkey();
}
