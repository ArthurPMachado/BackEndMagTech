package br.com.fiap.magtech.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.magtech.dao.UsuarioDao;
import br.com.fiap.magtech.entity.Usuario;

public class UsuarioDaoImpl extends GenericDAOImpl<Usuario, Integer> implements UsuarioDao{

	public UsuarioDaoImpl(EntityManager manager) {
		super(manager);
	}
}
