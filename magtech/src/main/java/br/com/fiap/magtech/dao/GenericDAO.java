package br.com.fiap.magtech.dao;

import br.com.fiap.magtech.exception.FailCommitException;
import br.com.fiap.magtech.exception.KeyNotFoundException;

public interface GenericDAO<T, K> {

	void create(T entity);
	T read(K key) throws KeyNotFoundException;
	void update(T entity);
	void delete(K key) throws KeyNotFoundException;
	void commit() throws FailCommitException; 
	
}
