package com.security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.security.demo.model.entity.ObjectEntity;
import com.security.demo.service.ObjectService;

public abstract class ObjectController<T extends ObjectEntity, S extends ObjectService<T, Integer>> implements IObjectController<T, Integer>{

	@Autowired
	protected S service;
	
}
