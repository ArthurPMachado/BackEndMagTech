package br.com.fiap.magtech.service;

import java.util.List;

import br.com.fiap.magtech.exception.KeyNotFoundException;
import br.com.fiap.magtech.model.Notificacao;

public interface NotificacaoService {
	
	void save(Notificacao notificacao);	
	
	void deleteAll();
	
	void deleteById(int id) throws KeyNotFoundException;
	
	List<Notificacao> findAll();
	
	Notificacao findById(int id) throws KeyNotFoundException;
}
