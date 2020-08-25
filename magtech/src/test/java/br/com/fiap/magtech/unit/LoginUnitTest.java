package br.com.fiap.magtech.unit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.fiap.magtech.model.Login;
import br.com.fiap.magtech.repository.LoginRepository;

@DataJpaTest
class LoginUnitTest {

	@Autowired
	private LoginRepository repository;

	private Login login;

	@BeforeEach
	@SuppressWarnings("unused")
	void populateDataForTest() {
		login = repository.save(new Login("algumacoisa@gmail.com", "123456"));
		Login login2 = repository.save(new Login("algumacoisa2@gmail.com", "123456"));
		Login login3 = repository.save(new Login("algumacoisa3@gmail.com", "123456"));
	}

	@Test
	void createShouldBeSuccessful() {
		assertThat(repository.count()).isEqualTo(3);
	}

	@Test
	void updateShouldBeSuccesful() {
		Login updatedLogin = repository.findById(login.getCodigo()).get();

		updatedLogin.setEmail("outroemail@gmail.com");
		updatedLogin.setRegistro("310673/08");

		repository.save(updatedLogin);

		assertThat(updatedLogin).isEqualTo(login);
	}

	@Test
	void repositoryShouldBeEmpty() {
		repository.deleteAll();

		assertThat(repository.count()).isEqualTo(0);
	}

	@Test
	void deleteShouldBeSuccessful() {
		Login willBeDeletedLogin = repository.findById(login.getCodigo()).get();
		
		long expected = repository.count() - 1;
		
		repository.deleteById(willBeDeletedLogin.getCodigo());
		
		assertThat(repository.count()).isEqualTo(expected);
	}
	
	@Test
	void listAllShouldBeSuccessful() {
		Iterable<?> logins = repository.findAll();
		
		assertThat(logins).hasSize((int) repository.count());
	}
	
	@Test
	void listSingleShouldBeSuccessful() {
		Login foundLogin = repository.findById(login.getCodigo()).get();

		assertThat(foundLogin).isEqualTo(login);
	}

	/*
	 * Criar testes para verificar as falhas do CRUD
	 * */
}
