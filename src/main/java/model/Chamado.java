package model;

import java.time.format.DateTimeFormatter;

public class Chamado {
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	private String idChamado;
	private String titulo;
	private String descricao;
	private String dataAbertura;
	private String dataFechamento;
	private String descricaoSolucao;
	private String idUsuario;
	private String idTecnico;
	
	public Chamado(String idChamado, String titulo, String descricao,
			String dataAbertura, String dataFechamento, 
			String descricaoSolucao, String idUsuario, String idTecnico) {
		super();
		this.idChamado = idChamado;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataAbertura = dataAbertura;
		this.dataFechamento = dataFechamento;
		this.descricaoSolucao = descricaoSolucao;
		this.idUsuario = idUsuario;
		this.idTecnico = idTecnico;
	}
	
	public Chamado() {
		super();
	}
	public void setDataFormatter(DateTimeFormatter dataFormatter) {
		this.dataFormatter = dataFormatter;
	}

	public String getIdChamado() {
		return idChamado;
	}

	public void setIdChamado(String idChamado) {
		this.idChamado = idChamado;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(String dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public String getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(String dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public String getDescricaoSolucao() {
		return descricaoSolucao;
	}

	public void setDescricaoSolucao(String descricaoSolucao) {
		this.descricaoSolucao = descricaoSolucao;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getIdTecnico() {
		return idTecnico;
	}

	public void setIdTecnico(String idTecnico) {
		this.idTecnico = idTecnico;
	}

	
	
}
