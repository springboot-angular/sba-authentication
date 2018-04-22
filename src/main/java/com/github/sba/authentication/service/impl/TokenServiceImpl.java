package com.github.sba.authentication.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.sba.authentication.Token;
import com.github.sba.authentication.entity.User;
import com.github.sba.authentication.service.TokenService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenServiceImpl implements TokenService {

	@Value("${authentication.jwt.expiration}")
	private Integer expirationTime;

	@Value("${authentication.jwt.key}")
	private String key;

	@Value("${authentication.jwt.prefix}")
	private String tokenPrefix;

	public Token generate(User user) {
		Map<String, Object> maps = new HashMap<>();
		maps.put("name", user.getName());
		maps.put("email", user.getEmail());

		String token = Jwts.builder().setSubject(user.getEmail()).setClaims(maps)
				.setExpiration(new Date(System.currentTimeMillis() + expirationTime))
				.signWith(SignatureAlgorithm.HS512, key).compact();

		return new Token(token);
	}

	@Override
	public String getkey() {
		return tokenPrefix;
	}

}
