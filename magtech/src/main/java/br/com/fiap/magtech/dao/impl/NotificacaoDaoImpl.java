package br.com.fiap.magtech.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.magtech.dao.NotificacaoDao;
import br.com.fiap.magtech.entity.Notificacao;

public class NotificacaoDaoImpl extends GenericDAOImpl<Notificacao, Integer> implements NotificacaoDao{

	public NotificacaoDaoImpl(EntityManager manager) {
		super(manager);
	}
	
}
