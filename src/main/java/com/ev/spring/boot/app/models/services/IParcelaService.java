package com.ev.spring.boot.app.models.services;

import java.util.List;

import com.ev.spring.boot.app.models.entity.Parcela;

public interface IParcelaService {


	public List<Parcela> findAll();
	
	public void save(Parcela parcela);
	
	public Parcela findById(Long id);
	
	public void deleteById(Long id);
	
}
