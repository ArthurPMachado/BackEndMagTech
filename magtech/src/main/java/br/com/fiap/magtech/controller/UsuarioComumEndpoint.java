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
import br.com.fiap.magtech.model.UsuarioComum;
import br.com.fiap.magtech.service.UsuarioComumService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioComumEndpoint {
	
	private UsuarioComumService usuarioComumDao;
	
	@Autowired
	public UsuarioComumEndpoint(UsuarioComumService usuarioComumDao) {
		this.usuarioComumDao = usuarioComumDao;
	}
	
	@PostMapping
	public ResponseEntity<?> insertUsuarioComum(@RequestBody UsuarioComum usuarioComum){
		return new ResponseEntity<> (usuarioComumDao.save(usuarioComum), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<?> updateUsuarioComum(@RequestBody UsuarioComum usuarioComum) {
		return new ResponseEntity<>(usuarioComumDao.save(usuarioComum), HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<?> clearDataBase(){
		usuarioComumDao.deleteAll();
		return new ResponseEntity<> (HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUsuarioComum(@PathVariable int id) throws KeyNotFoundException{
		UsuarioComum foundUsuario = usuarioComumDao.findById(id);
		if(foundUsuario == null) {
			throw new KeyNotFoundException("Não existe esse usuario no banco, verifique as credencias.");
		}
		usuarioComumDao.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping
	public ResponseEntity<?> listAll() {
		return new ResponseEntity<> (usuarioComumDao.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUsuarioComumById(@PathVariable("id") int id) throws KeyNotFoundException{
		UsuarioComum foundUsuario = usuarioComumDao.findById(id);
		if(foundUsuario == null) {
			 return new ResponseEntity<>(new KeyNotFoundException("Usuario Comum não encontrado"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(foundUsuario, HttpStatus.FOUND);
	}
}
