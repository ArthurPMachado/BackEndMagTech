package br.com.fiap.magtech.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.magtech.dao.ConfiguracaoDao;
import br.com.fiap.magtech.entity.ConfiguracaoGeral;

public class ConfiguracaoDaoImpl extends GenericDAOImpl<ConfiguracaoGeral, Integer> implements ConfiguracaoDao{

	public ConfiguracaoDaoImpl(EntityManager manager) {
		super(manager);
	} 
	
}
