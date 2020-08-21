package br.com.fiap.magtech.unit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.fiap.magtech.entity.Comentario;
import br.com.fiap.magtech.entity.Login;
import br.com.fiap.magtech.entity.Post;
import br.com.fiap.magtech.entity.UsuarioComum;
import br.com.fiap.magtech.entity.emum.Genero;
import br.com.fiap.magtech.repository.ComentarioRepository;
import br.com.fiap.magtech.repository.LoginRepository;
import br.com.fiap.magtech.repository.PostRepository;
import br.com.fiap.magtech.repository.UsuarioComumRepository;

@DataJpaTest
class ComentarioUnitTest {
	
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	@Autowired
	private PostRepository postRepository;
	

	@Autowired
	private UsuarioComumRepository usuarioComumRepository;
	
	@Autowired
	private LoginRepository loginRepository;
	
	private Comentario comentario;
	private Post post;
	private UsuarioComum usuarioComum;
	private Login login;

	@BeforeEach
	@SuppressWarnings("unused")
	void create() {
		login = loginRepository.save(new Login("algumacoisa@gmail.com", "123456"));
		usuarioComum = usuarioComumRepository.save(new UsuarioComum("João Pereira da Silva", "25/02/1988", "http://localdafoto", "SP", 11978456913L, Genero.Masculino, login, "AB-", 0, 0, 1));
		post = postRepository.save(new Post("Um post retratando a realidade da pandemia", 1, System.currentTimeMillis(), "Algum conteudo relevante ou uma imagem", usuarioComum));
		
		comentario = comentarioRepository.save(new Comentario(System.currentTimeMillis(), "Algum comentário feito pelo usuário", "http://imagemenviada", post));
		Comentario comentario2 = comentarioRepository.save(new Comentario(System.currentTimeMillis(), "Algum comentário feito pelo usuário", "http://imagemenviada", post));
		Comentario comentario3 = comentarioRepository.save(new Comentario(System.currentTimeMillis(), "Algum comentário feito pelo usuário", "http://imagemenviada", post));
	}
	
	@Test
	void createShouldBeSuccessful() {
		long expectedTotal = comentarioRepository.count() + 1;
		
		Comentario comentario4 = comentarioRepository.save(new Comentario(System.currentTimeMillis(), "Algum comentário feito pelo usuário", "http://imagemenviada", post));
		
		assertThat(comentarioRepository.count()).isEqualTo(expectedTotal);
	}
	
	@Test
	void updateShouldBeSuccessful() {
		Comentario updatedComentario = comentarioRepository.findById(comentario.getCodigo()).get();
		
		updatedComentario.setConteudo("Mudando o post que já tinha sido criado");
		updatedComentario.setImagem("http://outrocaminhoparaimagem");
		
		comentarioRepository.save(updatedComentario);
		
		assertThat(updatedComentario).isEqualTo(comentario);
	}
	
	@Test
	void repositoryShouldBeEmpty() {
		comentarioRepository.deleteAll();
		
		assertThat(comentarioRepository.count()).isEqualTo(0);
	}
	
	@Test
	void deleteShouldBeSuccessful() {
		Comentario willBeDeletedComentario = comentarioRepository.findById(comentario.getCodigo()).get();
		
		long expected = comentarioRepository.count() - 1;
		
		comentarioRepository.deleteById(willBeDeletedComentario.getCodigo());
		
		assertThat(comentarioRepository.count()).isEqualTo(expected);
	}
	
	@Test
	void listAllShouldBeSuccessful() {
		Iterable<Comentario> comentarios = comentarioRepository.findAll();
		
		assertThat(comentarios).hasSize((int) comentarioRepository.count());
	}
	
	@Test
	void listSingleShouldBeSuccessful() {		
		Comentario foundComentario = comentarioRepository.findById(comentario.getCodigo()).get();
				
		assertThat(foundComentario).isEqualTo(comentario);
	}
	
	/*
	 * Criar testes para verificar as falhas do CRUD
	 * */

}
