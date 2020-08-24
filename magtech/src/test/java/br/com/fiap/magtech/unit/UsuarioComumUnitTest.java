package br.com.fiap.magtech.unit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.fiap.magtech.entity.Login;
import br.com.fiap.magtech.entity.UsuarioComum;
import br.com.fiap.magtech.entity.emum.Genero;
import br.com.fiap.magtech.repository.LoginRepository;
import br.com.fiap.magtech.repository.UsuarioComumRepository;

@DataJpaTest
class UsuarioComumUnitTest {

	@Autowired
	private LoginRepository repositoryLogin;
	
	@Autowired
	private UsuarioComumRepository repositoryUsuario;
	
	private Login login;
	
	private UsuarioComum usuarioComum;
	
	@BeforeEach
	void populateDataForTest() {
		login = repositoryLogin.save(new Login("algumacoisa@gmail.com", "123456"));
		usuarioComum = repositoryUsuario.save(new UsuarioComum("Braufagélio", "01/01/2000", "foto.com", "SP", 924246969,
																	Genero.Masculino, login,"AB", 0, 0, 0));
		Login login0 = repositoryLogin.save(new Login("algumacoisa1@gmail.com", "123456"));
		repositoryUsuario.save(new UsuarioComum("Braufagélio", "01/01/2000", "foto.com", "SP", 924246969,
																	Genero.Masculino, login0,"AB", 0, 0, 0));
	}
	
	@Test
	void createShouldBeSuccessful() {
		long expectedTotal = repositoryUsuario.count() + 1;
		Login login1 = repositoryLogin.save(new Login("algumacoisa2@gmail.com", "123456"));
		repositoryUsuario.save(new UsuarioComum("Braufagélio", "01/01/2000", "foto.com", "SP", 924246969,
																Genero.Masculino, login1,"AB", 0, 0, 0));
		assertThat(repositoryUsuario.count()).isEqualTo(expectedTotal);
	}
	
	@Test
	void updateShouldBeSuccessful() {
		UsuarioComum updatedUsuario = repositoryUsuario.findById(usuarioComum.getCodigo()).get();
		updatedUsuario.setGenero(Genero.Feminino);
		repositoryUsuario.save(updatedUsuario);
		assertThat(usuarioComum).isEqualTo(updatedUsuario);
	}
	
	@Test
	void repositoryShoulBeEmpty() {
		repositoryUsuario.deleteAll();
		assertThat(repositoryUsuario.count()).isEqualTo(0);
	}
	
	@Test
	void deleteByIdShouldBeSuccessful()	{
		UsuarioComum usuarioWillBeDeleted = repositoryUsuario.findById(usuarioComum.getCodigo()).get();
		long expectedSize = repositoryUsuario.count() - 1;
		// expected Size of repository after delete operation
		repositoryUsuario.deleteById(usuarioWillBeDeleted.getCodigo());
		assertThat(repositoryUsuario.count()).isEqualTo(expectedSize);
	}
	
	@Test
	void listAllShouldBeSuccessful() {
		Iterable<UsuarioComum> usuarios = repositoryUsuario.findAll();
		assertThat(usuarios).hasSize((int) repositoryUsuario.count());
	}
	
	@Test
	void listByIdShouldBeSuccessful() {
		UsuarioComum foundUsuario = repositoryUsuario.findById(usuarioComum.getCodigo()).get();
		assertThat(foundUsuario).isEqualTo(usuarioComum);
	}
}
