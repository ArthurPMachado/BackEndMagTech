package br.com.fiap.magtech.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.magtech.dao.ProfissionalSaudeDao;
import br.com.fiap.magtech.entity.ProfissionalSaude;

public class ProfissionalSaudeDaoImpl extends GenericDAOImpl<ProfissionalSaude, Integer> implements ProfissionalSaudeDao{

	public ProfissionalSaudeDaoImpl(EntityManager manager) {
		super(manager);
	}
}
