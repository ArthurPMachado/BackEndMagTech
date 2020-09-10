package br.com.fiap.magtech.service;

import java.util.List;

import br.com.fiap.magtech.exception.KeyNotFoundException;
import br.com.fiap.magtech.model.Mensagem;

public interface MensagemService {
	void save(Mensagem mensagem);	
	void deleteAll();
	void deleteById(int id) throws KeyNotFoundException;
	List<Mensagem> findAll();
	Mensagem findById(int id) throws KeyNotFoundException;	
}
