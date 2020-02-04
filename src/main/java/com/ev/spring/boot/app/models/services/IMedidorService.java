package com.ev.spring.boot.app.models.services;

import java.util.List;

import com.ev.spring.boot.app.models.entity.Medidor;

public interface IMedidorService {


	public List<Medidor> findAll();
	
	public void save(Medidor medidor);
	
	public Medidor findById(Long id);
	
	public void deleteById(Long id);

}
