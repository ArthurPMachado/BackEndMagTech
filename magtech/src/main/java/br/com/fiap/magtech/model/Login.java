package br.com.fiap.magtech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "T_MAGTECH_LOGIN")
@SequenceGenerator(name = "login", sequenceName = "SQ_TB_LOGIN", allocationSize = 1)
@JsonIdentityInfo(
		 generator = ObjectIdGenerators.PropertyGenerator.class,
		 property = "codigo"
)
public class Login {
	
	@Id
	@Column(name = "cd_login", nullable = false, precision = 6)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "login")
	private int codigo;
	
	@Column(name = "ds_email", nullable = false, length = 50, unique = true)
	private String email;
	
	@Column(name = "ds_senha", nullable = false, length = 25)
	private String senha;
	
	@Column(name = "ds_registro", length = 12, unique = true)
	private String registro;
	
	@Column(name = "st_verificacao_duas_etapas", precision = 1)
	private int verificacaoDuasEtapas;
	
	// Relacionamento
	
	@OneToOne(mappedBy = "login")
	private Usuario usuario;
	
	public Login(String email, String senha, String registro) {
		super();
		this.email = email;
		this.senha = senha;
		this.registro = registro;
	}
	
	public Login(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}
	
	public Login() {
		super();
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
