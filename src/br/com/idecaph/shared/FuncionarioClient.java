package br.com.idecaph.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class FuncionarioClient implements IsSerializable {
	private Long id;
	private String identificacao;
	private String nome;
	private String cargo;
	private String departamento;

	public FuncionarioClient() {
	}

	public FuncionarioClient(Long id, String nome, String identificacao,
			String cargo, String departamento) {
		this.id = id;
		this.identificacao = identificacao;
		this.cargo = cargo;
		this.nome = nome;
		this.departamento = departamento;
	}

	public String getCargo() {
		return cargo;
	}

	public String getNome() {
		return nome;
	}

	public String getDepartamento() {
		return departamento;
	}

	public String getIdentificacao() {
		return identificacao;
	}

	public Long getId() {
		return id;
	}

	public String getDisplayNome() {
		return nome;
	}

	public String getDisplayIdentificacao() {
		return identificacao;
	}

	public String getDisplayCargo() {
		return cargo;
	}

	public String getDisplayDepartamento() {
		return departamento;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
}
