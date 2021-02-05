package com.security.demo.model.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.security.demo.model.entity.ObjectEntity;

@NoRepositoryBean
public interface ObjectRepository<T extends ObjectEntity, ID extends Serializable> extends CrudRepository<T, ID> {

}
