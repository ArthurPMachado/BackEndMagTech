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
import br.com.fiap.magtech.model.ProfissionalSaude;
import br.com.fiap.magtech.service.ProfissionalSaudeService;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalSaudeEndpoint {
	
	private final ProfissionalSaudeService profissionalSaudeDao;

	@Autowired
	public ProfissionalSaudeEndpoint(ProfissionalSaudeService profissionalSaudeDao) {
		this.profissionalSaudeDao = profissionalSaudeDao;
	}
	
	@PostMapping
	public ResponseEntity<?> insertProfissionalSaude(@RequestBody ProfissionalSaude profissionalSaude){
		profissionalSaudeDao.save(profissionalSaude);
		return new ResponseEntity<> (HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<?> updateProfissionalSaude(@RequestBody ProfissionalSaude profissionalSaude) {
		profissionalSaudeDao.save(profissionalSaude);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<?> clearDataBase(){
		profissionalSaudeDao.deleteAll();
		return new ResponseEntity<> (HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{id")
	public ResponseEntity<?> deleteProfissionalSaude(@PathVariable int id) throws KeyNotFoundException{
		ProfissionalSaude foundProfissional = profissionalSaudeDao.findById(id);
		if(foundProfissional == null) {
			throw new KeyNotFoundException("Não existe esse usuario no banco, verifique as credencias.");
		}
		profissionalSaudeDao.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping
	public ResponseEntity<?> listAll() {
		return new ResponseEntity<> (profissionalSaudeDao.findAll(), HttpStatus.FOUND);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getProfissionalSaude(@PathVariable int id) throws KeyNotFoundException{
		ProfissionalSaude foundProfissional = profissionalSaudeDao.findById(id);
		if(foundProfissional == null) {
			throw new KeyNotFoundException("Usuario Comum não encontrado");
		}
		return new ResponseEntity<>(foundProfissional, HttpStatus.FOUND);
	}
	
}
