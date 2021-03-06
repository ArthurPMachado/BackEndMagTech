package br.com.fiap.magtech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_MAGTECH_MENSAGEM")
@SequenceGenerator(name = "mensagem", sequenceName = "SQ_T_MENSAGEM", allocationSize = 1)
public class Mensagem {

	@Id
	@Column(name = "cd_mensagem", nullable = false, precision = 9)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mensagem")
	private int codigo;
	
	@Column(name = "dt_postagem", nullable = false)
	private long dtPostagem;
	
	@Column(name = "ds_conteudo", length = 400)
	private String conteudo;
	
	@Column(name = "fl_imagem", length = 200)
	private String imagem;
	
	// Foreign Key

	@ManyToOne
	@JoinColumn(name="cd_usuario")
	private Usuario usuario;
	
	public Mensagem(long dtPostagem, String conteudo, String imagem, Usuario usuario) {
		super();
		this.dtPostagem = dtPostagem;
		this.conteudo = conteudo;
		this.imagem = imagem;
		this.usuario = usuario;
	}
	
	public Mensagem(long dtPostagem, String conteudo, Usuario usuario) {
		super();
		this.dtPostagem = dtPostagem;
		this.conteudo = conteudo;
		this.usuario = usuario;
	}
	
	public Mensagem() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public long getDtPostagem() {
		return dtPostagem;
	}

	public void setDtPostagem(long dtPostagem) {
		this.dtPostagem = dtPostagem;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	
	
}
