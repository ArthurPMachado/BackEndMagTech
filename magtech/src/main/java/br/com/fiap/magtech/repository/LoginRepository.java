package br.com.fiap.magtech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.magtech.model.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {

}
