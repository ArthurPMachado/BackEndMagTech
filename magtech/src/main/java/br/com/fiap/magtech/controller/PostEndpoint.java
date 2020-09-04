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
import br.com.fiap.magtech.model.Post;
import br.com.fiap.magtech.service.PostService;

@RestController
@RequestMapping("/post")
public class PostEndpoint {

	private final PostService postDao;
	
	@Autowired
	public PostEndpoint (PostService postDao) {
		this.postDao = postDao;
	}
	
	@PostMapping
	public ResponseEntity<?> insertPost(@RequestBody Post post) {
		postDao.save(post);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<?> updatePost(@RequestBody Post post) {
		postDao.save(post);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<?> clearDataBase(){
		postDao.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePost(@PathVariable int id) throws KeyNotFoundException {
		Post foundPost = postDao.findById(id);
		if(foundPost == null) {
			throw new KeyNotFoundException("Não existe esse post");
		}
		postDao.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping
	public ResponseEntity<?> listAll() {
		return new ResponseEntity<> (postDao.findAll(), HttpStatus.FOUND);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable int id) throws KeyNotFoundException {
		Post foundPost = postDao.findById(id);
		if(foundPost == null) {
			throw new KeyNotFoundException("Post não encontrado");
		}
		return new ResponseEntity<> (foundPost, HttpStatus.FOUND);
	}
	
	// Under implementation
	/*
	@GetMapping("/findByTitulo/{titulo}")
	public ResponseEntity<?> getByTitulo(@PathVariable String titulo) {
		return new ResponseEntity<> (postDao.findByTitulo(titulo), HttpStatus.OK);
	}
	*/
	
}
