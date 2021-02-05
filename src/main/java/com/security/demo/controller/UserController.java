package com.security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.demo.model.entity.User;
import com.security.demo.service.GeneratorDTO;
import com.security.demo.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController extends ObjectController<User, UserService> {

	@Autowired
	GeneratorDTO dtoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		User entity = service.find(id);
		HttpStatus status = HttpStatus.OK;
		return ResponseEntity.status(status).body(dtoService.fromUserToUserDTO(entity));
	}

	@GetMapping("/real/{id}")
	public ResponseEntity<?> findReal(@PathVariable Integer id) {
		User entity = service.find(id);
		HttpStatus status = HttpStatus.OK;
		return ResponseEntity.status(status).body(entity);
	}
	
	@PostMapping("")
	public ResponseEntity<?> save(@RequestBody User entity) {
		service.save(entity);
		HttpStatus status = HttpStatus.OK;
		return ResponseEntity.status(status).body(dtoService.fromUserToUserDTO(entity));
	}

}
