package com.github.sba.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.sba.authentication.bean.UserBean;
import com.github.sba.authentication.entity.User;
import com.github.sba.authentication.service.UserService;

@RestController
@RequestMapping(value = "/registerUsers", produces = "application/json")
public class RegisterUserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST)
	public User create(@RequestBody UserBean userBean) {
		return userService.create(userBean);
	}

}
