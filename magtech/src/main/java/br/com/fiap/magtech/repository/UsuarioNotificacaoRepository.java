package br.com.fiap.magtech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.magtech.model.UsuarioNotificacao;
import br.com.fiap.magtech.model.UsuarioNotificacaoPK;

public interface UsuarioNotificacaoRepository extends JpaRepository<UsuarioNotificacao, UsuarioNotificacaoPK> {

}
