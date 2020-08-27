package br.com.fiap.magtech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.com.fiap.magtech.model.emum.Genero;

@Entity
@Table(name = "T_MAGTECH_USUARIO_COMUM")
@PrimaryKeyJoinColumn(name = "cd_usuario")
public class UsuarioComum extends Usuario {

	@Column(name = "ds_tipo_sanguineo", nullable = false, length = 3)
	private String tpSangue;

	@Column(name = "st_fumante", nullable = false, precision = 1)
	private int fumante;

	@Column(name = "st_abstemia", nullable = false, precision = 1)
	private int abstemia;

	@Column(name = "st_doador", nullable = false, precision = 1)
	private int doador;

	// Campo em string para indicar a uri do documento
	@Column(name = "fl_exames", length = 200)
	private String exames;

	// Campo em string para indicar a uri do documento
	@Column(name = "fl_historico_consulta", length = 200)
	private String historico;

	@Column(name = "st_categoria", precision = 1)
	private int categoria;

	@Column(name = "ds_alergia", length = 70)
	private String alergia;

	@Column(name = "ds_doenca", length = 70)
	private String doenca;

	@Column(name = "ds_remedio_controlado", length = 70)
	private String remedioCtrl;

	@OneToOne
	@JoinColumn(name = "cd_usuario")
	private Usuario usuario;

	public UsuarioComum(String nome, String dtNascimento, String foto, String estado, long telefone,
							Genero genero, Login login, String tpSangue, int fumante, int abstemia, int doador,
								String exames, String historico, int categoria, String alergia, String doenca, String remedioCtrl) {
		super(nome, dtNascimento, foto, estado, telefone, genero, login);
		this.tpSangue = tpSangue;
		this.fumante = fumante;
		this.abstemia = abstemia;
		this.doador = doador;
		this.exames = exames;
		this.historico = historico;
		this.categoria = categoria;
		this.alergia = alergia;
		this.doenca = doenca;
		this.remedioCtrl = remedioCtrl;
	}

	public UsuarioComum(String nome, String dtNascimento, String foto, String estado,
			long telefone, Genero genero, Login login, String tpSangue, int fumante, int abstemia, int doador) {
		super(nome, dtNascimento, foto, estado, telefone, genero, login);
		this.tpSangue = tpSangue;
		this.fumante = fumante;
		this.abstemia = abstemia;
		this.doador = doador;
	}

	public UsuarioComum() {
		super();
	}

	public String getTpSangue() {
		return tpSangue;
	}

	public void setTpSangue(String tpSangue) {
		this.tpSangue = tpSangue;
	}

	public int isFumante() {
		return fumante;
	}

	public void setFumante(int fumante) {
		this.fumante = fumante;
	}

	public int isAbstemia() {
		return abstemia;
	}

	public void setAbstemia(int abstemia) {
		this.abstemia = abstemia;
	}

	public int isDoador() {
		return doador;
	}

	public void setDoador(int doador) {
		this.doador = doador;
	}

	public String getExames() {
		return exames;
	}

	public void setExames(String exames) {
		this.exames = exames;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public String getAlergia() {
		return alergia;
	}

	public void setAlergia(String alergia) {
		this.alergia = alergia;
	}

	public String getDoenca() {
		return doenca;
	}

	public void setDoenca(String doenca) {
		this.doenca = doenca;
	}

	public String getRemedioCtrl() {
		return remedioCtrl;
	}

	public void setRemedioCtrl(String remedioCtrl) {
		this.remedioCtrl = remedioCtrl;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
