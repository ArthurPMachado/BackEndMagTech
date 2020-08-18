package br.com.fiap.magtech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_MAGTECH_COMENTARIO")
@SequenceGenerator(name="comentario", sequenceName="SQ_T_COMENTARIO", allocationSize=1)
public class Comentario {
	
	@Id
	@Column(name="cd_comentario", precision=11)
	@GeneratedValue(generator="comentario", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="dt_comentario", nullable=false)
	private long dataComentario;
	
	@Column(name="ds_conteudo", length=4000)
	private String conteudo;
	
	@Column(name="fl_imagem", length=200)
	private String imagem;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cd_post", nullable = false)
	private Post post;
	
	public Comentario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Comentario(long dataComentario, String conteudo, Post post) {
		super();
		this.dataComentario = dataComentario;
		this.conteudo = conteudo;
		this.post = post;
	}

	public Comentario(long dataComentario, String conteudo, String imagem, Post post) {
		super();
		this.dataComentario = dataComentario;
		this.conteudo = conteudo;
		this.imagem = imagem;
		this.post = post;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public long getDataComentario() {
		return dataComentario;
	}

	public void setDataComentario(long dataComentario) {
		this.dataComentario = dataComentario;
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

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
}
