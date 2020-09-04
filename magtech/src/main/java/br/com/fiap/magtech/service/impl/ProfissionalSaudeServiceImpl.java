package br.com.fiap.magtech.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.magtech.exception.KeyNotFoundException;
import br.com.fiap.magtech.model.ProfissionalSaude;
import br.com.fiap.magtech.repository.ProfissionalSaudeRepository;

@Service
public class ProfissionalSaudeServiceImpl implements br.com.fiap.magtech.service.ProfissionalSaudeService {

	private ProfissionalSaudeRepository repository;
	
	@Autowired
	public ProfissionalSaudeServiceImpl(ProfissionalSaudeRepository repository) {
		this.repository = repository;
	}

	@Override
	public void save(ProfissionalSaude profissionalSaude) {
		repository.save(profissionalSaude);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

	@Override
	public void deleteById(int id) throws KeyNotFoundException {
		repository.deleteById(id);
	}

	@Override
	public List<ProfissionalSaude> findAll() {
		return repository.findAll();
	}

	@Override
	public ProfissionalSaude findById(int id) throws KeyNotFoundException {
		Optional<ProfissionalSaude> foundProfissionalSaude = repository.findById(id);
		ProfissionalSaude profissionalSaude = null;
		if(foundProfissionalSaude.isPresent()) {
			profissionalSaude = foundProfissionalSaude.get();
		} else {
			throw new KeyNotFoundException("Este usuário não foi encontrado");
		}
		return profissionalSaude;
	}

	@Override
	public List<ProfissionalSaude> findByNome(String nome) {
		return repository.findByNome(nome);
	}

}
