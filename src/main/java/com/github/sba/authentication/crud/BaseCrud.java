package com.github.sba.authentication.crud;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.github.sba.authentication.entity.User;

public interface BaseCrud<T, P> {

	Page<T> getAll(Pageable pageable);

	T get(P id);

	void requiredFields(User user);

	T create(T object);

	T update(T object);

	T remove(P id);

}
