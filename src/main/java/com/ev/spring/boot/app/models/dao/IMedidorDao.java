package com.ev.spring.boot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ev.spring.boot.app.models.entity.Medidor;

public interface IMedidorDao extends CrudRepository<Medidor, Long> {

}
