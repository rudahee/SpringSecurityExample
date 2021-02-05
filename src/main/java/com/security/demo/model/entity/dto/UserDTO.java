package com.security.demo.model.entity.dto;

import java.util.Set;

import com.security.demo.model.UserRole;


public class UserDTO {

	private String username;
	private String password;
	private String name;
	private String surname;
	private Integer age;
	private String email;
	private Set<UserRole> roles;
	
	public UserDTO(String username, String password, String name, String surname, Integer age, String email,
			Set<UserRole> roles) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.email = email;
		this.roles = roles;
	}

	public UserDTO(String username, String password, String email, Set<UserRole> roles) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.roles = roles;
	}

	public UserDTO() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}
	
	
	
}
