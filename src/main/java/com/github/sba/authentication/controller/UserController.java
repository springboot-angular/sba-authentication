package com.github.sba.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.sba.authentication.entity.User;
import com.github.sba.authentication.service.UserService;

@RestController
@RequestMapping(value = "/users", produces = "application/json")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public Page<User> get(Pageable pageable) {
		return userService.getAll(pageable);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public User update(@RequestBody User user) {
		return userService.update(user);
	}

	@RequestMapping(value = "/{email}", method = RequestMethod.DELETE)
	public User remove(@PathVariable(name = "email") String email, @RequestBody User user) {
		return userService.remove(email);
	}

}
