package br.com.idecaph.shared;

import br.com.idecaph.client.view.colunas.InformacaoTabela;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Funcionario extends InformacaoTabela {
	private String nome;
	private String identificacao;
	private String cargo;
	private String departamento;

	public Funcionario() {

	}

	public Funcionario(String nome, String identificacao, String cargo,
			String departamento) {
		this.nome = nome;
		this.identificacao = identificacao;
		this.cargo = cargo;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public String getIdentificacao() {
		return identificacao;
	}

	public String getCargo() {
		return cargo;
	}

	public String getDepartamento() {
		return departamento;
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
}
