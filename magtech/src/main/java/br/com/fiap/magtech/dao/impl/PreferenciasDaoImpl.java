package br.com.fiap.magtech.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.magtech.dao.PreferenciaDao;
import br.com.fiap.magtech.entity.Preferencias;

public class PreferenciasDaoImpl extends GenericDAOImpl<Preferencias, Integer> implements PreferenciaDao{

	public PreferenciasDaoImpl(EntityManager manager) {
		super(manager);
	}
	
}
