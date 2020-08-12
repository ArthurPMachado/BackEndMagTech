package br.com.fiap.magtech.unit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import br.com.fiap.magtech.entity.Login;
import br.com.fiap.magtech.repository.PostRepository;

@DataJpaTest
class PostUnitTest {
	
	@Autowired
	private TestEntityManager manager;
	
	@Autowired
	private PostRepository repository;

	@Test
	void create() {
		Login login = repository.save(new Login("tutupmachado@gmail.com", "123456"));
		
		assertThat(login).hasFieldOrPropertyWithValue("email", "tutupmachado@gmail.com");
		assertThat(login).hasFieldOrPropertyWithValue("senha", "123456");
		
	}
	
	@Test
	void listAll() {
		Login login1 = new Login("tutupmachado@gmail.com", "123456");
		manager.persist(login1);
		
		Login login2 = new Login("machadoparthur1@gmail.com", "987654");
		manager.persist(login2);
		
		Login login3 = new Login("arthurpereiramachado01@gmail.com", "braufagelio");
		manager.persist(login3);
		
		Iterable<Login> logins = repository.findAll();
		
		assertThat(logins).hasSize(3).contains(login1, login2, login3);
	}

}
