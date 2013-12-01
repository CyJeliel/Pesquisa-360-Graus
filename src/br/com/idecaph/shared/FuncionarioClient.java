package br.com.idecaph.shared;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

public class FuncionarioClient implements IsSerializable, Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String login;
	private String senha;
	private String confirmacaoSenha;
	private String identificacao;
	private String nome;
	private String cargo;
	private String departamento;
	private Boolean admin;

	public FuncionarioClient() {
	}

	public FuncionarioClient(Long id, String login, String senha,
			String confirmacaoSenha, String nome, String identificacao,
			String cargo, String departamento, Boolean admin) {
		this(id, login, senha, nome, identificacao, cargo, departamento, admin);
		this.confirmacaoSenha = confirmacaoSenha;
	}

	public FuncionarioClient(Long id, String login, String senha, String nome,
			String identificacao, String cargo, String departamento, Boolean admin) {
		this(id, nome, identificacao, cargo, departamento);
		this.login = login;
		this.senha = senha;
		this.admin = admin;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmacaoSenha() {
		return confirmacaoSenha;
	}

	public void setConfirmacaoSenha(String confirmacaoSenha) {
		this.confirmacaoSenha = confirmacaoSenha;
	}

	public Boolean isAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
}
