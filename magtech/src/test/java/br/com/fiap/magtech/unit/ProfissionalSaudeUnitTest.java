package br.com.fiap.magtech.unit;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.fiap.magtech.model.Login;
import br.com.fiap.magtech.model.ProfissionalSaude;
import br.com.fiap.magtech.model.emum.Genero;
import br.com.fiap.magtech.repository.LoginRepository;
import br.com.fiap.magtech.repository.ProfissionalSaudeRepository;

@DataJpaTest
class ProfissionalSaudeUnitTest {
	
	@Autowired
	private LoginRepository repositoryLogin;
	
	@Autowired
	private ProfissionalSaudeRepository repositoryProfissional;
	
	private Login login;
	
	private ProfissionalSaude profissionalSaude;

	@BeforeEach
	void populateDataForTest() {
		login = repositoryLogin.save(new Login("algumacoisa@gmail.com", "123456"));
		profissionalSaude = repositoryProfissional.save(new ProfissionalSaude("Braufagélio", "01/01/2000", "foto.com", "SP", 924246969,
															Genero.Masculino, login,"1234/3", "Cardiologista", "DBC"));
		
		Login login0 = repositoryLogin.save(new Login("algumacoisa1@gmail.com", "123456"));
		repositoryProfissional.save(new ProfissionalSaude("Francinaldo", "01/01/2000", "foto.com", "SP", 924246969,
															Genero.Masculino, login0,"1234/4", "èdiatra", "DDS"));
	}
	
	@Test
	void createShouldBeSuccessful() {
		long expectedTotal = repositoryProfissional.count() + 1;
		Login login1 = repositoryLogin.save(new Login("algumacoisa2@gmail.com", "123456"));
		repositoryProfissional.save(new ProfissionalSaude("Judiscrei", "01/01/2000", "foto.com", "SP", 924246969,
										Genero.Masculino, login1, "1112223/4", "AlgumaCoisa", "ABC"));
		assertThat(repositoryProfissional.count()).isEqualTo(expectedTotal);
	}
	
	@Test
	void updateShouldBeSuccessful() {
		ProfissionalSaude updatedUsuario = repositoryProfissional.findById(profissionalSaude.getCodigo()).get();
		updatedUsuario.setGenero(Genero.Feminino);
		repositoryProfissional.save(updatedUsuario);
		assertThat(profissionalSaude).isEqualTo(updatedUsuario);
	}
	
	@Test
	void repositoryShoulBeEmpty() {
		repositoryProfissional.deleteAll();
		assertThat(repositoryProfissional.count()).isEqualTo(0);
	}
	
	@Test
	void deleteByIdShouldBeSuccessful()	{
		ProfissionalSaude usuarioWillBeDeleted = repositoryProfissional.findById(profissionalSaude.getCodigo()).get();
		long expectedSize = repositoryProfissional.count() - 1;
		// expected Size of repository after delete operation
		repositoryProfissional.deleteById(usuarioWillBeDeleted.getCodigo());
		
		assertThat(repositoryProfissional.count()).isEqualTo(expectedSize);
	}
	
	@Test
	void listAllShouldBeSuccessful() {
		Iterable<ProfissionalSaude> usuarios = repositoryProfissional.findAll();
		
		assertThat(usuarios).hasSize((int) repositoryProfissional.count());
	}
	
	@Test
	void listByIdShouldBeSuccessful() {
		ProfissionalSaude foundUsuario = repositoryProfissional.findById(profissionalSaude.getCodigo()).get();
		
		assertThat(foundUsuario).isEqualTo(profissionalSaude);
	}
	
}