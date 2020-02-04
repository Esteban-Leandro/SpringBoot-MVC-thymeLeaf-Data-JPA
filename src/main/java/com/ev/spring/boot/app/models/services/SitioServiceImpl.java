package com.ev.spring.boot.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ev.spring.boot.app.models.dao.ISitioDao;
import com.ev.spring.boot.app.models.entity.Sitio;

@Service
public class SitioServiceImpl implements ISitioService {

	@Autowired
	private ISitioDao sitioDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Sitio> findAll() {
		// TODO Auto-generated method stub
		return (List<Sitio>) sitioDao.findAll();
	}

	@Override
	@Transactional
	public void save(Sitio sitio) {
		// TODO Auto-generated method stub
		sitioDao.save(sitio);
	}

	@Override
	@Transactional(readOnly = true)
	public Sitio findById(Long id) {
		// TODO Auto-generated method stub
		return sitioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		sitioDao.deleteById(id);
	}

}
