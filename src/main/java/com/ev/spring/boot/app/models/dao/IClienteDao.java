package com.ev.spring.boot.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ev.spring.boot.app.models.entity.Cliente;

public interface IClienteDao extends PagingAndSortingRepository<Cliente, Long>{
	
}
