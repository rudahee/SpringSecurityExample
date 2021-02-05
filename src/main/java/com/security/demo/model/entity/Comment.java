package com.security.demo.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Comment extends ObjectEntity {
	
	private String title;
	private String comment;
	
	@ManyToOne(optional=true, cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	public Comment(Integer id, String title, String comment) {
		super(id);
		this.title = title;
		this.comment = comment;
	}
	
	public Comment(Integer id) {
		super(id);

	}
	
	public Comment() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
