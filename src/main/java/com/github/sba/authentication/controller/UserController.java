package com.github.sba.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.sba.authentication.bean.UserBean;
import com.github.sba.authentication.entity.User;
import com.github.sba.authentication.service.UserService;

@RestController
@RequestMapping(value = "/users", produces = "application/json")
public class UserController {

	@Autowired
	private UserService userService;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.GET)
	public Page<User> get(Pageable pageable) {
		return userService.getAll(pageable);
	}

	@RequestMapping(value = "/{email}", method = RequestMethod.GET)
	public User get(@PathVariable(name = "email") String email, Pageable pageable) {
		return userService.get(email);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public User update(@RequestBody UserBean user) {
		return userService.update(user);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public User remove(@RequestBody UserBean user) {
		return userService.remove(user.getEmail());
	}

}
