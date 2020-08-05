package br.com.fiap.magtech.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.magtech.dao.LoginDao;
import br.com.fiap.magtech.entity.Login;

public class LoginDaoImpl extends GenericDAOImpl<Login, Integer> implements LoginDao{

	public LoginDaoImpl(EntityManager manager) {
		super(manager);
	}

}
