package br.com.fiap.magtech.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.magtech.exception.KeyNotFoundException;
import br.com.fiap.magtech.model.Login;
import br.com.fiap.magtech.repository.LoginRepository;
import br.com.fiap.magtech.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	private LoginRepository repository;
	
	@Autowired
	public LoginServiceImpl(LoginRepository repository) {
		this.repository = repository;
	}

	@Override
	public void save(Login login) {
		repository.save(login);
	}

	@Override
	public List<Login> findAll() {
		return repository.findAll();
	}

	@Override
	public Login findById(int id) throws KeyNotFoundException {
		Optional<Login> foundLogin = repository.findById(id);
		
		Login login = null;
		
		if(foundLogin.isPresent()) {
			login = foundLogin.get();
		} else {
			throw new KeyNotFoundException("Esse login não pode ser encontrado, verifique as credenciais e tente novamente");
		}
		
		return login;
	}

	@Override
	public void deleteById(int id) {
		repository.deleteById(id);
	}

}
