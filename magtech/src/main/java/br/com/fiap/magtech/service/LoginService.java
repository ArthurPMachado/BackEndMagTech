package br.com.fiap.magtech.service;

import java.util.List;

import br.com.fiap.magtech.exception.KeyNotFoundException;
import br.com.fiap.magtech.model.Login;

public interface LoginService {

	void save(Login login);
	
	List<Login> findAll();
	
	Login findById(int id) throws KeyNotFoundException;
	
	void deleteById(int id) throws KeyNotFoundException;

}
