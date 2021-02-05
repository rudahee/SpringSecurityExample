package com.security.demo.model.repository;

import org.springframework.stereotype.Repository;

import com.security.demo.model.entity.Comment;

@Repository
public interface CommentRepository extends ObjectRepository<Comment, Integer> {

}
