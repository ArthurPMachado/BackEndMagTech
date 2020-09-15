package br.com.fiap.magtech.unit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.fiap.magtech.model.Login;
import br.com.fiap.magtech.model.Notificacao;
import br.com.fiap.magtech.model.UsuarioComum;
import br.com.fiap.magtech.model.UsuarioNotificacao;
import br.com.fiap.magtech.model.UsuarioNotificacaoPK;
import br.com.fiap.magtech.model.emum.Genero;
import br.com.fiap.magtech.repository.LoginRepository;
import br.com.fiap.magtech.repository.NotificacaoRepository;
import br.com.fiap.magtech.repository.UsuarioComumRepository;
import br.com.fiap.magtech.repository.UsuarioNotificacaoRepository;

@DataJpaTest
class UsuarioNotificacaoUnitTest {

	@Autowired
	private UsuarioNotificacaoRepository usuarioNotificacaoRepository;
	
	@Autowired
	private UsuarioComumRepository usuarioComumRepository;
	
	@Autowired
	private NotificacaoRepository notificacaoRepository;
	
	@Autowired
	private LoginRepository loginRepository;
	
	private UsuarioNotificacao usuarioNotificacao;
	private UsuarioComum usuarioComum;
	private Notificacao notificacao;
	private Login login;
	
	@BeforeEach
	@SuppressWarnings("unused")
	void populateDataForTest() {
		login = loginRepository.save(new Login("algumacoisa@gmail.com", "123456"));
		usuarioComum = usuarioComumRepository.save(new UsuarioComum("João Pereira da Silva", "25/02/1988", "http://localdafoto", "SP", 11978456913L, Genero.Masculino, login, "AB-", 0, 0, 1));
		notificacao = notificacaoRepository.save(new Notificacao("Chegou nova mensagem para você pra testar!", "http://iconedanotificacao"));
		Notificacao notificacao2 = notificacaoRepository.save(new Notificacao("Chegou nova mensagem para você!", "http://iconedanotificacao"));
		Notificacao notificacao3 = notificacaoRepository.save(new Notificacao("Chegou nova mensagem para você!", "http://iconedanotificacao"));
		
		usuarioNotificacao = usuarioNotificacaoRepository.save(new UsuarioNotificacao(usuarioComum, notificacao, System.currentTimeMillis()));
		UsuarioNotificacao usuarioNotificacao2 = usuarioNotificacaoRepository.save(new UsuarioNotificacao(usuarioComum, notificacao2, System.currentTimeMillis()));
		UsuarioNotificacao usuarioNotificacao3 = usuarioNotificacaoRepository.save(new UsuarioNotificacao(usuarioComum, notificacao3, System.currentTimeMillis()));
	}
	
	@Test
	void createShouldBeSuccessful() {
		long expectedTotal = usuarioNotificacaoRepository.count() + 1;
				
		Notificacao notificacao4 = notificacaoRepository.save(new Notificacao("Chegou nova mensagem para você!", "http://iconedanotificacao"));
		usuarioNotificacaoRepository.save(new UsuarioNotificacao(usuarioComum, notificacao4, System.currentTimeMillis()));
		
		assertThat(usuarioNotificacaoRepository.count()).isEqualTo(expectedTotal);
	}
	
	@Test
	void repositoryShouldBeEmpty() {
		usuarioNotificacaoRepository.deleteAll();
		
		assertThat(usuarioNotificacaoRepository.count()).isEqualTo(0);
	}
	
	@Test
	void deleteByNotificacaoShouldBeSuccessful() {
		UsuarioNotificacaoPK pks = new UsuarioNotificacaoPK(usuarioComum.getCodigo(), notificacao.getCodigo());
		
		UsuarioNotificacao willBeDeletedUsuarioNotificacao = usuarioNotificacaoRepository.findById(pks).get();
		
		long expected = usuarioNotificacaoRepository.count() - 1;
		
		usuarioNotificacaoRepository.delete(willBeDeletedUsuarioNotificacao);
		
		assertThat(usuarioNotificacaoRepository.count()).isEqualTo(expected);
	}
	

}
