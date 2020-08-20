package br.com.fiap.magtech.unit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.fiap.magtech.entity.Login;
import br.com.fiap.magtech.entity.Post;
import br.com.fiap.magtech.entity.UsuarioComum;
import br.com.fiap.magtech.entity.emum.Genero;
import br.com.fiap.magtech.repository.LoginRepository;
import br.com.fiap.magtech.repository.PostRepository;
import br.com.fiap.magtech.repository.UsuarioComumRepository;

@DataJpaTest
class PostUnitTest {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private UsuarioComumRepository usuarioComumRepository;
	
	private Post post;
	private Login usuarioLogin;
	private UsuarioComum usuarioComum;
	
	@BeforeEach
	@SuppressWarnings("unused")
	void populateDataForTest() {
		usuarioLogin = loginRepository.save(new Login("algumacoisa@gmail.com", "123456"));
		usuarioComum = usuarioComumRepository.save(new UsuarioComum("Braufagélio", "01/01/2000", "foto.com", "SP", 924246969 ,Genero.Masculino, usuarioLogin,"AB", 0, 0, 0));
		
		post = postRepository.save(new Post("P", 1, 11111111111L, "blablabla", 1, "imagem", usuarioComum));
		Post postUserComum = postRepository.save(new Post("P1", 1, 11111111111L, "blablabla", 1, "imagem", usuarioComum));
		Post postUserComum1 = postRepository.save(new Post("P2", 1, 11111111111L, "blablabla", 1, "imagem", usuarioComum));
	}
	
	@Test
	void createShouldBeSuccessful() {
		assertThat(postRepository.count()).isEqualTo(3);
	}
	
	@Test
	void UpdateShouldBeSuccessful() {
		Post updatedPost = postRepository.findById(post.getCodigo()).get();
		
		updatedPost.setConteudo("Novo conteudo");
		
		postRepository.save(updatedPost);
		
		assertThat(updatedPost.getConteudo()).isEqualTo(post.getConteudo());
	}
	
	@Test
	void repositoryShouldBeEmpty() {
		postRepository.deleteAll();
		assertThat(postRepository.count()).isEqualTo(0);
	}
	
	@Test
	void deleteByIdShouldBeSuccessful() {
		Post postWillBeDeleted = postRepository.findById(post.getCodigo()).get();
		// expected Size of repository after delete operation
		long expectedSize = postRepository.count() - 1;
		
		postRepository.deleteById(postWillBeDeleted.getCodigo());
		assertThat(postRepository.count()).isEqualTo(expectedSize);
	}
	
	@Test
	void listAllShouldBeSuccessful() {
		Iterable<Post> posts = postRepository.findAll();
		
		assertThat(posts).hasSize((int) postRepository.count());
	}
	
	@Test
	void listByIdShouldBeSuccessful() {
		Post foundPost = postRepository.findById(post.getCodigo()).get();
		
		assertThat(foundPost).isEqualTo(post);
	}
}
