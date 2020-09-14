package br.com.fiap.magtech.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.magtech.exception.KeyNotFoundException;
import br.com.fiap.magtech.model.Mensagem;
import br.com.fiap.magtech.repository.MensagemRepository;
import br.com.fiap.magtech.service.MensagemService;

@Service
public class MensagemServiceImpl implements MensagemService{

	private MensagemRepository repository;
	
	@Autowired
	public MensagemServiceImpl(MensagemRepository repository) {
		this.repository = repository;
	}

	@Override
	public void save(Mensagem mensagem) {
		repository.save(mensagem);
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
	public List<Mensagem> findAll() {
		return repository.findAll();
	}

	@Override
	public Mensagem findById(int id) throws KeyNotFoundException {
		Optional<Mensagem> foundmensagem = repository.findById(id);
		Mensagem mensagem = null;
		if(foundmensagem.isPresent()) {
			mensagem = foundmensagem.get();
		} else {
			throw new KeyNotFoundException("Mensagem não encontrada");
		}
		return mensagem;
	}

}
