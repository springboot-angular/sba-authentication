package com.github.sba.authentication.service.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.sba.authentication.bean.UserBean;
import com.github.sba.authentication.entity.QUser;
import com.github.sba.authentication.entity.User;
import com.github.sba.authentication.exceptions.PermissionDeniedException;
import com.github.sba.authentication.exceptions.UserAlreadyExistsException;
import com.github.sba.authentication.exceptions.UserInvalidFieldException;
import com.github.sba.authentication.exceptions.UserNotFoundException;
import com.github.sba.authentication.exceptions.UserNotNullException;
import com.github.sba.authentication.repository.UserRepository;
import com.github.sba.authentication.security.UserLoggedService;
import com.github.sba.authentication.service.UserService;
import com.querydsl.core.types.dsl.BooleanExpression;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserLoggedService userLoggedService;

	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly = true)
	@Override
	public Page<User> getAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	public void requiredFields(UserBean userBean) {
		if (userBean == null)
			throw new UserNotNullException("Usuário não encontrado");

		if (userBean.getEmail() == null || userBean.getEmail().trim().equals(""))
			throw new UserInvalidFieldException("Email não preenchido");

		if (userBean.getName() == null || userBean.getName().trim().equals(""))
			throw new UserInvalidFieldException("Nome não preenchido");
	}

	@Transactional(readOnly = true)
	@Override
	public User get(String email) {
		if (email == null)
			throw new UserInvalidFieldException("Email obrigatório");

		QUser qUser = QUser.user;
		BooleanExpression expression = qUser.email.eq((String) email).and(qUser.active.isTrue());
		User user = userRepository.findOne(expression);

		if (user == null)
			throw new UserNotNullException("Usuário não encontrado");

		return user;
	}

	@Transactional
	@Override
	public User create(UserBean userBean) {
		this.requiredFields(userBean);

		if (userRepository.findOne(userBean.getEmail()) != null)
			throw new UserAlreadyExistsException("Usuário já cadastrado");

		User user = new User();
		user.setEmail(userBean.getEmail());
		user.setPassword(userBean.getPassword());
		user.setName(userBean.getName());
		user.setCreateDataTime(new Timestamp(System.currentTimeMillis()));
		user.setUpdateDateTime(new Timestamp(System.currentTimeMillis()));
		user.setActive(true);

		return userRepository.save(user);
	}

	@Transactional
	public User update(UserBean userBean) {
		this.requiredFields(userBean);

		if (!userBean.getEmail().equals(userLoggedService.get().getEmail()))
			throw new PermissionDeniedException("Permissão negada, você só pode atualizar seus dados");

		User userUpdate = userRepository.findOne(userBean.getEmail());

		if (userUpdate == null)
			throw new UserNotFoundException("Usuário não encontrado");

		userUpdate.setName(userBean.getName());
		userUpdate.setUpdateDateTime(new Timestamp(System.currentTimeMillis()));
		userUpdate.setActive(userBean.isActive());

		return userRepository.save(userUpdate);
	}

	@Transactional
	public User remove(String email) {
		if (email == null)
			throw new UserNotNullException("Email não pode ser nulo");

		User user = userRepository.findOne(email);

		if (user == null)
			throw new UserNotNullException("Usuário não encontrado");

		if (!email.equals(userLoggedService.get().getEmail()))
			throw new PermissionDeniedException("Permissão negada, você só pode excluir seus dados");

		userRepository.delete(user);

		return user;
	}

}
