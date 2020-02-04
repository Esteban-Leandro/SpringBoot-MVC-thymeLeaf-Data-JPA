package com.ev.spring.boot.app.models.services;

import java.util.List;

import com.ev.spring.boot.app.models.entity.Cliente;

public interface IClienteService {
	
	public List<Cliente> findAll();
	
	public void save(Cliente cliente);
	
	public Cliente findById(Long id);
	
	public void deleteById(Long id);

}
