package br.com.fiap.magtech.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.magtech.dao.ComentarioDao;
import br.com.fiap.magtech.entity.Comentario;

public class ComentarioDaoImpl extends GenericDAOImpl<Comentario, Integer> implements ComentarioDao{

	public ComentarioDaoImpl(EntityManager manager) {
		super(manager);
	}
}
