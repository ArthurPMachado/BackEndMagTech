package br.com.fiap.magtech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "T_MAGTECH_PROFISSIONAL_SAUDE")
@PrimaryKeyJoinColumn(name = "cd_usuario")
public class ProfissionalSaude extends Usuario {

	@Column(name = "ds_identificacao_prof", length = 12, nullable = false, unique = true)
	private String identificacao;

	@Column(name = "ds_cargo", length = 100, nullable = false)
	private String cargo;

	@Column(name = "nm_instituicao_saude", length = 50, nullable = false)
	private String nomeInstituicao;

	@Column(name = "nr_telefone_instituicao", precision = 11, nullable = true)
	private long telefone;

	@OneToOne
	@JoinColumn(name = "cd_usuario")
	private Usuario usuario;

	public ProfissionalSaude(String identificacao, String cargo, String nomeInstituicao, long telefone) {
		super();
		this.identificacao = identificacao;
		this.cargo = cargo;
		this.nomeInstituicao = nomeInstituicao;
		this.telefone = telefone;
	}

	public ProfissionalSaude() {
		super();
	}

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getNomeInstituicao() {
		return nomeInstituicao;
	}

	public void setNomeInstituicao(String nomeInstituicao) {
		this.nomeInstituicao = nomeInstituicao;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
