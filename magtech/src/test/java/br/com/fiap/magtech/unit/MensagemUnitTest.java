package br.com.fiap.magtech.unit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.fiap.magtech.entity.emum.Genero;
import br.com.fiap.magtech.model.Login;
import br.com.fiap.magtech.model.Mensagem;
import br.com.fiap.magtech.model.UsuarioComum;
import br.com.fiap.magtech.repository.LoginRepository;
import br.com.fiap.magtech.repository.MensagemRepository;
import br.com.fiap.magtech.repository.UsuarioComumRepository;

@DataJpaTest
class MensagemUnitTest {

	@Autowired
	private MensagemRepository mensagemRepository;
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private UsuarioComumRepository usuarioComumRepository;
	
	private Mensagem mensagem;
	private UsuarioComum usuarioComum;
	private Login login;
	
	@BeforeEach
	void populateDataForTest() {
		login = loginRepository.save(new Login("algumacoisa@gmail.com", "123456"));
		usuarioComum = usuarioComumRepository.save(new UsuarioComum("João Pereira da Silva", "25/02/1988", "http://localdafoto", "SP", 11978456913L, Genero.Masculino, login, "AB-", 0, 0, 1));
		
		mensagem = mensagemRepository.save(new Mensagem(System.currentTimeMillis(), "Algum conteudo da mensagem", "http://umaimagemproamigo", usuarioComum));
		Mensagem mensagem2 = mensagemRepository.save(new Mensagem(System.currentTimeMillis(), "Algum conteudo da mensagem", "http://umaimagemproamigo", usuarioComum));
		Mensagem mensagem3 = mensagemRepository.save(new Mensagem(System.currentTimeMillis(), "Algum conteudo da mensagem", "http://umaimagemproamigo", usuarioComum));
	}
	
	@Test
	void createShouldBeSuccessful() {
		long expectedTotal = mensagemRepository.count() + 1;
		
		Mensagem mensagem4 = mensagemRepository.save(new Mensagem(System.currentTimeMillis(), "Algum conteudo da mensagem", "http://umaimagemproamigo", usuarioComum));
		
		assertThat(mensagemRepository.count()).isEqualTo(expectedTotal);
	}
	
	@Test
	void updateShouldBeSuccessful() {
		Mensagem updatedMensagem = mensagemRepository.findById(mensagem.getCodigo()).get();
		
		updatedMensagem.setConteudo("Outra mensagem que eu enviei");
		
		assertThat(mensagem).isEqualTo(updatedMensagem);
	}
	
	@Test
	void repositoryShouldBeEmpty() {
		mensagemRepository.deleteAll();
		
		assertThat(mensagemRepository.count()).isEqualTo(0);
	}
	
	@Test
	void deleteByIdShouldBeSuccessful() {
		Mensagem willBeDeletedMensagem = mensagemRepository.findById(mensagem.getCodigo()).get();
		
		long expected = mensagemRepository.count() - 1;
		
		mensagemRepository.deleteById(willBeDeletedMensagem.getCodigo());
		
		assertThat(mensagemRepository.count()).isEqualTo(expected);
	}
	
	@Test
	void listAllShouldBeSuccessful() {
		Iterable<Mensagem> mensagens = mensagemRepository.findAll();
		
		assertThat(mensagens).hasSize((int) mensagemRepository.count());
	}
	
	@Test
	void listByIdShouldBeSuccessful() {
		Mensagem foundMensagem = mensagemRepository.findById(mensagem.getCodigo()).get();
		
		assertThat(foundMensagem).isEqualTo(mensagem);
	}
	
	/*
	 * Criar testes para verificar as falhas do CRUD
	 * */
}
