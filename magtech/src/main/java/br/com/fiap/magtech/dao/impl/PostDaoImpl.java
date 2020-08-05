package br.com.fiap.magtech.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.magtech.dao.PostDao;
import br.com.fiap.magtech.entity.Post;

public class PostDaoImpl extends GenericDAOImpl<Post, Integer> implements PostDao{

	public PostDaoImpl(EntityManager manager) {
		super(manager);
	}
}
