package com.security.demo.controller;

import java.io.Serializable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.security.demo.model.entity.ObjectEntity;

public interface IObjectController<T extends ObjectEntity, ID extends Serializable> {
	public ResponseEntity<?> findAll();
	public ResponseEntity<?> find(@PathVariable ID id);
	public ResponseEntity<?> save(@RequestBody T entity);
	public ResponseEntity<?> edit(@PathVariable ID id, @RequestBody T entity);
	public ResponseEntity<?> delete(@PathVariable ID id);

}
