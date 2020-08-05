package br.com.fiap.magtech.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.magtech.dao.UsuarioComumDao;
import br.com.fiap.magtech.entity.UsuarioComum;

public class UsuarioComumDaoImpl extends GenericDAOImpl<UsuarioComum, Integer> implements UsuarioComumDao{

	public UsuarioComumDaoImpl(EntityManager manager) {
		super(manager);
	}
}
