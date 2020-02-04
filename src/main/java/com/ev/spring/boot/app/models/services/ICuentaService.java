package com.ev.spring.boot.app.models.services;

import java.util.List;

import com.ev.spring.boot.app.models.entity.Cuenta;

public interface ICuentaService {

	public List<Cuenta> findAll();
	
	public void save(Cuenta cuenta);
	
	public Cuenta findById(Long id);
	
	public void deleteById(Long id);

}
