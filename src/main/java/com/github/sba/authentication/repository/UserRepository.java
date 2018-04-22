package com.github.sba.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphQueryDslPredicateExecutor;
import com.github.sba.authentication.entity.User;

public interface UserRepository extends JpaRepository<User, String>, QueryDslPredicateExecutor<User>,
		EntityGraphQueryDslPredicateExecutor<User> {

}
