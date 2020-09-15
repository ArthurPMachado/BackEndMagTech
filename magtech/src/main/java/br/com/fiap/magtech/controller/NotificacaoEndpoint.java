package br.com.fiap.magtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.magtech.exception.KeyNotFoundException;
import br.com.fiap.magtech.model.Notificacao;
import br.com.fiap.magtech.service.NotificacaoService;

@RestController
@RequestMapping("/notificacao")
public class NotificacaoEndpoint {
	
	private final NotificacaoService dao;

	@Autowired
	public NotificacaoEndpoint(NotificacaoService dao) {
		this.dao = dao;
	}
	
	@PostMapping
	public ResponseEntity<?> insertNotificacao(@RequestBody Notificacao notificacao) {
		dao.save(notificacao);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<?> updateNotificacao(@RequestBody Notificacao notificacao) {
		dao.save(notificacao);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<?> clearDataBase(){
		dao.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteNotificacao(@PathVariable int id) throws KeyNotFoundException {
		Notificacao foundNotificacao = dao.findById(id);
		if(foundNotificacao == null) {
			throw new KeyNotFoundException("Não existe essa notificacao");
		}
		dao.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping
	public ResponseEntity<?> listAll() {
		return new ResponseEntity<> (dao.findAll(), HttpStatus.FOUND);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable int id) throws KeyNotFoundException {
		Notificacao foundNotificacao = dao.findById(id);
		if(foundNotificacao == null) {
			throw new KeyNotFoundException("Notificacao não encontrado");
		}
		return new ResponseEntity<> (foundNotificacao, HttpStatus.FOUND);
	}
	
}
