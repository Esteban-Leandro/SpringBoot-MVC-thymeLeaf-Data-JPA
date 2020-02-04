package com.ev.spring.boot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ev.spring.boot.app.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{
	
}
