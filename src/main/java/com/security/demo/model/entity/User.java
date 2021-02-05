package com.security.demo.model.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.security.demo.model.UserRole;

@SuppressWarnings("serial")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class User extends ObjectEntity implements UserDetails {



	@Column(unique = true)
	private String username;
	private String password;
	private String name;
	private String surname;
	private Integer age;
	private String email;
	
	private Boolean locked;
	
	@CreatedDate
	private LocalDateTime createTime;
	
	@UpdateTimestamp
	private LocalDateTime updateTime;
	
	private LocalDateTime deleteTime;
	
	private LocalDateTime lastPasswordChange;
	
	private LocalDateTime nextPasswordChange;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@Enumerated(EnumType.STRING)
	private Set<UserRole> roles;
	
    @OneToMany(mappedBy="user")
	private List<Comment> comments;
	
	public User(Integer id, String name, String surname, Integer age, String email,
			String password) {
		super(id);
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.email = email;
		this.password = password;
		this.locked = false;
		this.nextPasswordChange = LocalDateTime.now();
		this.nextPasswordChange.plusMonths(3);
		this.roles = new HashSet<UserRole>();
	}

	public User(Integer id) {
		super(id);
		this.roles = new HashSet<UserRole>();
		this.locked = false;
		this.nextPasswordChange = LocalDateTime.now();
		this.nextPasswordChange.plusMonths(3);
	}
	
	public User() {
		super();
		this.roles = new HashSet<UserRole>();
		this.locked = false;
		this.nextPasswordChange = LocalDateTime.now();
		this.nextPasswordChange.plusMonths(3);
	}

	public Set<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}
	
	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		//return (this.getDeleteTime().compareTo(LocalDateTime.now())) > 0 ? true : false;
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		//return (this.getNextPasswordChange().compareTo(LocalDateTime.now()) > 0) ? true : false;
		return false;
	}

	@Override
	public boolean isEnabled() {
		return this.locked;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles.stream().map(ur -> new SimpleGrantedAuthority("ROLE_"+ur.name())).collect(Collectors.toList());
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

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	public void addComment(Comment comment) {
		this.comments.add(comment);
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	public LocalDateTime getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(LocalDateTime deleteTime) {
		this.deleteTime = deleteTime;
	}

	public LocalDateTime getLastPasswordChange() {
		return lastPasswordChange;
	}

	public void setLastPasswordChange(LocalDateTime lastPasswordChange) {
		this.lastPasswordChange = lastPasswordChange;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public LocalDateTime getNextPasswordChange() {
		return nextPasswordChange;
	}

	public void setNextPasswordChange(LocalDateTime nextPasswordChange) {
		this.nextPasswordChange = nextPasswordChange;
	}
	
	
}
