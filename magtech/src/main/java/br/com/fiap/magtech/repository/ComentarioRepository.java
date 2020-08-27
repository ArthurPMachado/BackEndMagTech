package br.com.fiap.magtech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.magtech.model.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {

}
