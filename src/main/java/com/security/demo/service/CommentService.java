package com.security.demo.service;

import org.springframework.stereotype.Service;

import com.security.demo.model.entity.Comment;
import com.security.demo.model.repository.ObjectRepository;

@Service
public class CommentService  extends ObjectService<Comment, Integer> {
	
	public CommentService(ObjectRepository<Comment, Integer> objectRepository) { 
		super(objectRepository);
	}	

}
