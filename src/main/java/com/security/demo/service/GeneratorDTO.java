package com.security.demo.service;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.security.demo.model.UserRole;
import com.security.demo.model.entity.User;
import com.security.demo.model.entity.dto.UserDTO;

public class GeneratorDTO {

	@Autowired
	private static PasswordEncoder passwordEncoder;
	
	public static User transformDTOtoUser(UserDTO dto) {
		User user  = new User();
		user.setUsername(dto.getUsername());
		user.setName(dto.getName());
		user.setSurname(dto.getSurname());
		user.setAge(dto.getAge());
		user.setEmail(dto.getEmail());
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		user.setRoles(Set.of(UserRole.USER));
		user.setCreateTime(LocalDateTime.now());
		user.setUpdateTime(LocalDateTime.now());
		user.setLastPasswordChange(LocalDateTime.now());
		
		return user;
	}
	
	public static UserDTO fromUserToUserDTO(User user) {
		
		UserDTO dto = new UserDTO(user.getUsername(), user.getPassword(), user.getName(), user.getSurname(), user.getAge(),
				user.getEmail(), user.getRoles());
		
		return dto;
	}
	
}
