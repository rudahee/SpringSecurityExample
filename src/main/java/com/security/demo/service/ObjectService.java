package com.security.demo.service;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import com.security.demo.model.entity.ObjectEntity;
import com.security.demo.model.repository.ObjectRepository;

@Transactional
public abstract class ObjectService <T extends ObjectEntity, ID extends Serializable> {
	
	protected ObjectRepository<T, ID> objectRepository;

	public ObjectService(ObjectRepository<T, ID> objectRepository) {
		this.objectRepository = objectRepository;
	}
	
	public T find(ID entityId) {
		return objectRepository.findById(entityId).get();
	}

	public List<T> findAll() {
		return (List<T>) objectRepository.findAll();
	}

	public T save(T entity) {
		return objectRepository.save(entity);
	}

	public T update(T entity, ID entityId) {
		// Save and update do the same thing
		return objectRepository.save(entity);
	}

	public void delete(ID entityId) {
		objectRepository.deleteById(entityId);
	}

}
