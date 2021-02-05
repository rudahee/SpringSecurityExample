package com.security.demo.service;

import org.springframework.stereotype.Service;

import com.security.demo.model.entity.User;
import com.security.demo.model.repository.ObjectRepository;

@Service
public class UserService extends ObjectService<User, Integer> {

			
	public UserService(ObjectRepository<User, Integer> objectRepository) { 
		super(objectRepository);
	}	


}
