package br.com.fiap.magtech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.magtech.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
	List<Post> findByTitulo(String titulo);
}
