package com.ev.spring.boot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ev.spring.boot.app.models.entity.Sitio;

public interface ISitioDao extends CrudRepository<Sitio, Long>{
	
	
}
