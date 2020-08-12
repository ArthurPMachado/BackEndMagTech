package br.com.fiap.magtech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.magtech.entity.Login;

public interface PostRepository extends JpaRepository<Login, Integer> {

}
