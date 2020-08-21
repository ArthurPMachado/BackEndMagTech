package br.com.fiap.magtech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.magtech.entity.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem, Integer> {

}
