package com.ev.spring.boot.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ev.spring.boot.app.models.dao.ICuentaDao;
import com.ev.spring.boot.app.models.entity.Cuenta;

@Service
public class CuentaServiceImpl implements ICuentaService {

	@Autowired
	private ICuentaDao cuentaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cuenta> findAll() {
		// TODO Auto-generated method stub
		return (List<Cuenta>) cuentaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Cuenta cuenta) {
		// TODO Auto-generated method stub
		cuentaDao.save(cuenta);
	}

	@Override
	@Transactional(readOnly = true)
	public Cuenta findById(Long id) {
		// TODO Auto-generated method stub
		return cuentaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		cuentaDao.deleteById(id);
	}

}
