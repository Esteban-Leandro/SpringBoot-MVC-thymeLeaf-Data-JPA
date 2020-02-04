package com.ev.spring.boot.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ev.spring.boot.app.models.dao.IMedidorDao;
import com.ev.spring.boot.app.models.entity.Medidor;

@Service
public class MedidorServiceImpl implements IMedidorService {

	@Autowired
	private IMedidorDao medidorDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Medidor> findAll() {
		// TODO Auto-generated method stub
		return (List<Medidor>) medidorDao.findAll();
	}

	@Override
	@Transactional
	public void save(Medidor medidor) {
		// TODO Auto-generated method stub
		medidorDao.save(medidor);
	}

	@Override
	@Transactional(readOnly = true)
	public Medidor findById(Long id) {
		// TODO Auto-generated method stub
		return medidorDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		medidorDao.deleteById(id);
	}

}
