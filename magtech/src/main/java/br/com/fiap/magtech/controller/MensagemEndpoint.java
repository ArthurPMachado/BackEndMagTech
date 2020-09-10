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
import br.com.fiap.magtech.model.Mensagem;
import br.com.fiap.magtech.service.MensagemService;

@RestController
@RequestMapping("/mensagem")
public class MensagemEndpoint {
	
	private final MensagemService dao;

	@Autowired
	public MensagemEndpoint(MensagemService dao) {
		this.dao = dao;
	}
	
	@PostMapping
	public ResponseEntity<?> insertMensagem(@RequestBody Mensagem mensagem) {
		dao.save(mensagem);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<?> updateMensagem(@RequestBody Mensagem mensagem) {
		dao.save(mensagem);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<?> clearDataBase(){
		dao.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteMensagem(@PathVariable int id) throws KeyNotFoundException {
		Mensagem foundMensagem = dao.findById(id);
		if(foundMensagem == null) {
			throw new KeyNotFoundException("Não existe esse mensagem");
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
		Mensagem foundMensagem = dao.findById(id);
		if(foundMensagem == null) {
			throw new KeyNotFoundException("Mensagem não encontrada");
		}
		return new ResponseEntity<> (foundMensagem, HttpStatus.FOUND);
	}
	
}
