package com.security.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.demo.model.entity.User;
import com.security.demo.service.GeneratorDTO;
import com.security.demo.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController extends ObjectController<User, UserService> {

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		User entity = service.find(id);
		HttpStatus status = HttpStatus.OK;
		return ResponseEntity.status(status).body(GeneratorDTO.fromUserToUserDTO(entity));
	}

	@Override
	@PostMapping
	public ResponseEntity<?> save(User entity) {
		service.save(entity);
		HttpStatus status = HttpStatus.OK;
		return ResponseEntity.status(status).body(entity);
	}

}
