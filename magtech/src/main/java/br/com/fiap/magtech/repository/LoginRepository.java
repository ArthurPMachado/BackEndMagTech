package br.com.fiap.magtech.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.magtech.model.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {
	Optional<Login> findByEmail(String email);
}
