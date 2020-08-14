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
	@DisplayName("Should create a comentary with success")
	void createSucess() {
		assertNotEquals(0, comentario.getCodigo());
	}
	
	@Test
	@DisplayName("Should get all comentaries with success")
	void listAllSucess() {
		Comentario comentario1 = repository.save(new Comentario(System.currentTimeMillis(), "Outro comentario", "http://imagemenviada"));
		Comentario comentario2 = repository.save(new Comentario(System.currentTimeMillis(), "Comentario sem imagem"));
		Comentario comentario3 = repository.save(new Comentario(System.currentTimeMillis(), "http://apenasimagemnocomentario"));
		
		Iterable<Comentario> comentarios = repository.findAll();
		
		assertThat(comentarios).hasSize(4).contains(comentario, comentario1, comentario2, comentario3);
	}
	
	@Test
	@DisplayName("Should get single comentary by id with success")
	void listSingleSuccess() {
		Comentario comentario1 = repository.save(new Comentario(System.currentTimeMillis(), "Outro comentario", "http://imagemenviada"));
		
		Comentario unicoComentario = repository.findById(comentario1.getCodigo()).get();
		
		assertThat(unicoComentario).isEqualTo(comentario1);
	}

}
