package com.security.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.demo.model.entity.Comment;
import com.security.demo.service.CommentService;

@RestController
@RequestMapping(path = "/comment")
public class CommentController extends ObjectController<Comment, CommentService>{

}
