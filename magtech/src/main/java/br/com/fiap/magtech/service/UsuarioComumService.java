package br.com.fiap.magtech.service;

import java.util.List;

import br.com.fiap.magtech.exception.KeyNotFoundException;
import br.com.fiap.magtech.model.UsuarioComum;;

public interface UsuarioComumService {
	
	void save(UsuarioComum usuarioComum);	
	
	void deleteAll();
	
	void deleteById(int id) throws KeyNotFoundException;
	
	List<UsuarioComum> findAll();
	
	UsuarioComum findById(int id) throws KeyNotFoundException;
	
	List<UsuarioComum> findByNome(String nome);

}
