package com.ev.spring.boot.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ev.spring.boot.app.models.dao.IParcelaDao;
import com.ev.spring.boot.app.models.entity.Parcela;

@Service
public class ParcelaServiceImpl implements IParcelaService {

	@Autowired
	private IParcelaDao parcelaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Parcela> findAll() {
		// TODO Auto-generated method stub
		return (List<Parcela>) parcelaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Parcela parcela) {
		// TODO Auto-generated method stub
		parcelaDao.save(parcela);
	}

	@Override
	@Transactional(readOnly = true)
	public Parcela findById(Long id) {
		// TODO Auto-generated method stub
		return parcelaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		parcelaDao.deleteById(id);
	}

}
