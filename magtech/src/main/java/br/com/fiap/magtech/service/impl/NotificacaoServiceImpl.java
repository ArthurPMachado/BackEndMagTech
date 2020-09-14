package br.com.fiap.magtech.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.magtech.exception.KeyNotFoundException;
import br.com.fiap.magtech.model.Notificacao;
import br.com.fiap.magtech.repository.NotificacaoRepository;
import br.com.fiap.magtech.service.NotificacaoService;

@Service
public class NotificacaoServiceImpl implements NotificacaoService {

	private NotificacaoRepository repository;
	
	@Autowired
	public NotificacaoServiceImpl(NotificacaoRepository repository) {
		this.repository = repository;
	}

	@Override
	public void save(Notificacao notificacao) {
		repository.save(notificacao);
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
	public List<Notificacao> findAll() {
		return repository.findAll();
	}

	@Override
	public Notificacao findById(int id) throws KeyNotFoundException {
		Optional<Notificacao> foundNotificacao = repository.findById(id);
		Notificacao notificacao = null;
		if(foundNotificacao.isPresent()) {
			notificacao = foundNotificacao.get();
		} else {
			throw new KeyNotFoundException("Notificação não encontrada");
		}
		return notificacao;
	}
	
}
