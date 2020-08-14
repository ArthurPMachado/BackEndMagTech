package br.com.fiap.magtech.unit;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import br.com.fiap.magtech.entity.Comentario;
import br.com.fiap.magtech.repository.ComentarioRepository;

@DataJpaTest
class ComentarioUnitTest {
	
	@Autowired
	private TestEntityManager manager;
	
	@Autowired
	private ComentarioRepository repository;
	
	private Comentario comentario;

	@BeforeEach
	void create() {
		comentario = repository.save(new Comentario(System.currentTimeMillis(), "Algum comentário feito pelo usuário", "http://imagemenviada"));
	}
	
	@Test
	@DisplayName("should create a film with sucess")
	void createSucess() {
		assertNotEquals(0, comentario.getCodigo());
	}

}
