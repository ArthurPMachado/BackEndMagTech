package br.com.fiap.magtech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.magtech.model.ProfissionalSaude;

public interface ProfissionalSaudeRepository extends JpaRepository<ProfissionalSaude, Integer>{
	List<ProfissionalSaude> findByNome(String nome);
}
