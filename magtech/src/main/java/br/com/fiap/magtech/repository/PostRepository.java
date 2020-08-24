package br.com.fiap.magtech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.magtech.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
