package br.com.fiap.magtech.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.magtech.dao.MensagemDao;
import br.com.fiap.magtech.entity.Mensagem;

public class MensagemDaoImpl extends GenericDAOImpl<Mensagem, Integer> implements MensagemDao{

	public MensagemDaoImpl(EntityManager manager) {
		super(manager);
	}
	
}
