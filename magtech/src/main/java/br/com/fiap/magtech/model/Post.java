package br.com.fiap.magtech.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_MAGTECH_POST")
@SequenceGenerator(name="post", sequenceName="SQ_T_POST", allocationSize=1)
public class Post {
	
	@Id
	@Column(name="cd_post", precision=9)
	@GeneratedValue(generator="post", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="ds_titulo", nullable=false ,length=50)
	private String titulo;
	
	@Column(name="st_post", nullable=false, precision=1)
	private int visibilidade;
	
	@Column(name="dt_postagem", nullable=false)
	private long postagem;
	
	@Column(name="ds_conteudo", length=4000)
	private String conteudo;
	
	@Column(name="st_reacao", precision=1)
	private int reacao;
	
	@Column(name="fl_imagem", length=200)
	private String imagem;
	 
	// Relacionamentos
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cd_usuario", nullable = false)
	private Usuario usuario;
	
	@OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private List<Comentario> comentarios;
	
	public void addComentario(Comentario novoComentario) {
		novoComentario.setPost(this);
		this.comentarios.add(novoComentario);
	}
	
	public Post() {
		super();
	}

	public Post(String titulo, int visibilidade, long postagem, String conteudo, Usuario usuario) {
		super();
		this.titulo = titulo;
		this.visibilidade = visibilidade;
		this.postagem = postagem;
		this.conteudo = conteudo;
		this.usuario = usuario;
	}
	
	public Post(String titulo, int visibilidade, long postagem, String conteudo, int reacao, String imagem, Usuario usuario) {
		super();
		this.titulo = titulo;
		this.visibilidade = visibilidade;
		this.postagem = postagem;
		this.conteudo = conteudo;
		this.reacao = reacao;
		this.imagem = imagem;
		this.usuario = usuario;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getVisibilidade() {
		return visibilidade;
	}

	public void setVisibilidade(int visibilidade) {
		this.visibilidade = visibilidade;
	}

	public long getPostagem() {
		return postagem;
	}

	public void setPostagem(long postagem) {
		this.postagem = postagem;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public int getReacao() {
		return reacao;
	}

	public void setReacao(int reacao) {
		this.reacao = reacao;
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

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
}
