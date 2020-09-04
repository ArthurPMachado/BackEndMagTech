package br.com.fiap.magtech.service;

import java.util.List;

import br.com.fiap.magtech.exception.KeyNotFoundException;
import br.com.fiap.magtech.model.ProfissionalSaude;

public interface ProfissionalSaudeService {
	
	void save(ProfissionalSaude profissionalSaude);	
	
	void deleteAll();
	
	void deleteById(int id) throws KeyNotFoundException;
	
	List<ProfissionalSaude> findAll();
	
	ProfissionalSaude findById(int id) throws KeyNotFoundException;
	
	List<ProfissionalSaude> findByNome(String nome);
}
