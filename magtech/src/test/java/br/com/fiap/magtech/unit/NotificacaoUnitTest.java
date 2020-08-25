package br.com.fiap.magtech.unit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.fiap.magtech.model.Notificacao;
import br.com.fiap.magtech.repository.NotificacaoRepository;

@DataJpaTest
class NotificacaoUnitTest {

	@Autowired
	private NotificacaoRepository repository;
	
	private Notificacao notificacao;
	
	@BeforeEach
	void populateDataForTest() {
		notificacao = repository.save(new Notificacao("Chegou nova mensagem para você!", "http://iconedanotificacao"));
		Notificacao notificacao2 = repository.save(new Notificacao("Chegou nova mensagem para você!", "http://iconedanotificacao"));
		Notificacao notificacao3 = repository.save(new Notificacao("Chegou nova mensagem para você!", "http://iconedanotificacao"));
	}
	
	@Test
	void createShouldBeSuccessful() {
		long expectedTotal = repository.count() + 1;
		
		Notificacao notificacao4 = repository.save(new Notificacao("Chegou nova mensagem para você!", "http://iconedanotificacao"));
		
		assertThat(repository.count()).isEqualTo(expectedTotal);
	}
	
	@Test
	void updateShouldBeSuccessful() {
		Notificacao updatedNotificacao = repository.findById(notificacao.getCodigo()).get();
		
		updatedNotificacao.setDescricao("Alterando a mensagem que chegou a você");
		
		repository.save(updatedNotificacao);
		
		assertThat(updatedNotificacao).isEqualTo(notificacao);
	}
	
	@Test
	void repositoryShouldBeEmpty() {
		repository.deleteAll();
		
		assertThat(repository.count()).isEqualTo(0);
	}

	@Test
	void deleteShouldBeSuccessful() {
		Notificacao willBeDeletedNotificacao = repository.findById(notificacao.getCodigo()).get();
		
		long expected = repository.count() - 1;
		
		repository.deleteById(willBeDeletedNotificacao.getCodigo());
		
		assertThat(repository.count()).isEqualTo(expected);
	}
	
	@Test
	void listAllShouldBeSuccessful() {
		Iterable<Notificacao> notificacoes = repository.findAll();
		
		assertThat(notificacoes).hasSize((int) repository.count());
	}
	
	@Test
	void listSingleShouldBeSuccessful() {
		Notificacao foundNotificacao = repository.findById(notificacao.getCodigo()).get();
		
		assertThat(foundNotificacao).isEqualTo(notificacao);
	}
	
	/*
	 * Criar testes para verificar as falhas do CRUD
	 * */
}
