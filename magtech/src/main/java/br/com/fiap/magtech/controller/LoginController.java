package br.com.fiap.magtech.controller;

import java.util.List;

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

import br.com.fiap.magtech.exception.EmailNotFoundException;
import br.com.fiap.magtech.exception.KeyNotFoundException;
import br.com.fiap.magtech.model.Login;
import br.com.fiap.magtech.service.LoginService;

@RestController
@RequestMapping("/logins")
public class LoginController {

	private LoginService service;

	@Autowired
	public LoginController(LoginService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<?> insertLogin(@RequestBody Login login) {
		service.save(login);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Login> listAll() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Login listById(@PathVariable int id) throws KeyNotFoundException {
		Login foundLogin = service.findById(id);
		
		if(foundLogin == null) {
			throw new KeyNotFoundException("O login não existe para esse usuário");
		}
		
		return foundLogin;
	}
	
	@GetMapping("/{email}")
	public Login getEmail(@PathVariable String email) throws EmailNotFoundException {
		Login foundLogin = service.findByEmail(email);	
		if(foundLogin == null) {
			throw new EmailNotFoundException("O Email não existe");
		}
		return foundLogin;
	}
	
	@PutMapping
	public ResponseEntity<?> updateLogin(@RequestBody Login login) {
		service.save(login);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteLogin(@PathVariable int id) throws KeyNotFoundException {
		Login foundLogin = service.findById(id);
		
		if(foundLogin == null) {
			throw new KeyNotFoundException("O login não existe para esse usuário");
		}
		
		service.deleteById(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/{email}")
	public Login loginAuthetication(@RequestBody Login login) throws Exception{
		Login foundLogin = service.verifyPassword(login);
		if(foundLogin == null) {
			throw new EmailNotFoundException("O Email não existe");
		}
		return foundLogin;
	}
	
	
}
