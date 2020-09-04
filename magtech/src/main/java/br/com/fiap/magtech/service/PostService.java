package br.com.fiap.magtech.service;

import java.util.List;

import br.com.fiap.magtech.exception.KeyNotFoundException;
import br.com.fiap.magtech.model.Post;

public interface PostService{

	void save(Post post);	
	
	void deleteAll();
	
	void deleteById(int id) throws KeyNotFoundException;
	
	List<Post> findAll();
	
	Post findById(int id) throws KeyNotFoundException;
	
	List<Post> findByTitulo(String titulo);
}
