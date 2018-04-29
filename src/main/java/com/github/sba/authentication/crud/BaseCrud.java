package com.github.sba.authentication.crud;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseCrud<T, P1, P2> {

	Page<T> getAll(Pageable pageable);

	T get(P2 id);

	void requiredFields(P1 user);

	T create(P1 object);

	T update(P1 object);

	T remove(P2 id);

}
