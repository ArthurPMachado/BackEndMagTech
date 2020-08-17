package br.com.fiap.magtech.unit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.fiap.magtech.entity.Post;
import br.com.fiap.magtech.repository.PostRepository;

@DataJpaTest
class PostUnitTest {
	
	@Autowired
	private PostRepository repository;
	
	private Post post;
	
	@BeforeEach
	@SuppressWarnings("unused")
	void populateDataForTest() {
		post = repository.save(new Post("P", 1, 11111111111L, "blablabla", 1, "imagem"));
		Post post0 = repository.save(new Post("P1", 1, 11111111111L, "blablabla", 1, "imagem"));
		Post post1 = repository.save(new Post("P2", 1, 11111111111L, "blablabla", 1, "imagem"));
		Post post2 = repository.save(new Post("P3", 1, 11111111111L, "blablabla", 1, "imagem"));
	}
	
	@Test
	void createShouldBeSuccessful() {
		System.out.println(repository.count());
		assertThat(repository.count()).isEqualTo(4);
	}
	
	@Test
	void UpdateShouldBeSuccessful() {
		Post updatedPost = repository.findById(post.getCodigo()).get();
		
		updatedPost.setConteudo("Novo conteudo");
		assertThat(updatedPost.getConteudo()).isEqualTo(post.getConteudo());
	}
	
	@Test
	void repositoryShouldBeEmpty() {
		repository.deleteAll();
		assertThat(repository.count()).isEqualTo(0);
	}
	
	@Test
	void deleteByIdShouldBeSuccessful() {
		Post postWillBeDeleted = repository.findById(post.getCodigo()).get();
		// expected Size of repository after delete operation
		long expectedSize = repository.count() - 1;
		
		repository.deleteById(postWillBeDeleted.getCodigo());
		assertThat(repository.count()).isEqualTo(expectedSize);
	}
	
	
	@Test
	void listAllShouldBeSuccessful() {
		Iterable<Post> posts = repository.findAll();
		
		assertThat(posts).hasSize((int) repository.count());
	}
	
	void listByIdShouldBeSuccessful() {
		Post foundPost = repository.findById(post.getCodigo()).get();
		
		assertThat(foundPost).isEqualTo(post);
	}
}
