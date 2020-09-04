package br.com.fiap.magtech.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.magtech.exception.KeyNotFoundException;
import br.com.fiap.magtech.model.Post;
import br.com.fiap.magtech.repository.PostRepository;
import br.com.fiap.magtech.service.PostService;

@Service
public class PostServiceImpl implements PostService{

	private PostRepository repository;
	
	@Autowired
	public PostServiceImpl(PostRepository repository) {
		this.repository = repository;
	}

	@Override
	public void save(Post post) {
		repository.save(post);
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
	public List<Post> findAll() {
		return repository.findAll();
	}

	@Override
	public Post findById(int id) throws KeyNotFoundException {
		Optional<Post> foundoPost = repository.findById(id);
		Post post = null;
		if(foundoPost.isPresent()) {
			post = foundoPost.get();
		} else {
			throw new KeyNotFoundException("Post não encontrado");
		}
		
		return post;
	}

	public List<Post> findByTitulo(String titulo){
		return repository.findByTitulo(titulo);
	}
	
}
