package com.security.demo.model.repository;

import org.springframework.stereotype.Repository;

import com.security.demo.model.entity.User;

@Repository
public interface UserRepository extends ObjectRepository<User, Integer> {

}
