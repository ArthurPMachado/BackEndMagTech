package br.com.fiap.magtech.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.magtech.exception.KeyNotFoundException;
import br.com.fiap.magtech.model.UsuarioComum;
import br.com.fiap.magtech.repository.UsuarioComumRepository;
import br.com.fiap.magtech.service.UsuarioComumService;

@Service
public class UsuarioComumServiceImpl implements UsuarioComumService{
	
	private UsuarioComumRepository repository;
	
	@Autowired
	public UsuarioComumServiceImpl(UsuarioComumRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public void save(UsuarioComum usuarioComum) {
		repository.save(usuarioComum);
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
	public List<UsuarioComum> findAll() {
		return repository.findAll();
	}

	@Override
	public UsuarioComum findById(int id) throws KeyNotFoundException {
		Optional<UsuarioComum> foundUsuarioComum = repository.findById(id);
		if(foundUsuarioComum.isPresent()) {
			return foundUsuarioComum.get();
		} else {
			throw new KeyNotFoundException("Usuario não encontrado");
		}
	}

	@Override
	public List<UsuarioComum> findByNome(String nome) {
		return repository.findByNome(nome);
	}	
	
}
