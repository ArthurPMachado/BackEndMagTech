package br.com.fiap.magtech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.magtech.model.UsuarioComum;

public interface UsuarioComumRepository extends JpaRepository<UsuarioComum, Integer>{
	List<UsuarioComum> findByNome(String nome);
}
