package com.ev.spring.boot.app.models.services;

import java.util.List;

import com.ev.spring.boot.app.models.entity.Sitio;

public interface ISitioService {


	public List<Sitio> findAll();
	
	public void save(Sitio sitio);
	
	public Sitio findById(Long id);
	
	public void deleteById(Long id);
	
}
