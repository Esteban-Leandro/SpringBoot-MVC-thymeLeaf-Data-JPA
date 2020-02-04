package com.ev.spring.boot.app.models.dao;


import org.springframework.data.repository.CrudRepository;

import com.ev.spring.boot.app.models.entity.Cuenta;

public interface ICuentaDao extends CrudRepository<Cuenta, Long>{

}
