package br.com.idecaph.model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import br.com.idecaph.shared.FuncionarioClient;
import br.com.idecaph.shared.FuncionarioSelecionavel;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Funcionario implements Entity {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;

	@Persistent
	private String login;

	@Persistent
	private String senha;

	@Persistent
	private String identificacao;

	@Persistent
	private String nome;

	@Persistent
	private String cargo;

	@Persistent
	private String departamento;
	
	@Persistent
	private Boolean admin;

	public Funcionario(FuncionarioClient funcionarioClient) {
		this.id = funcionarioClient.getId();
		this.login = funcionarioClient.getLogin();
		this.senha = funcionarioClient.getSenha();
		this.identificacao = funcionarioClient.getIdentificacao();
		this.cargo = funcionarioClient.getCargo();
		this.nome = funcionarioClient.getNome();
		this.departamento = funcionarioClient.getDepartamento();
		this.admin = funcionarioClient.isAdmin();
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
		return this.login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Boolean isAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public FuncionarioSelecionavel getFuncionarioSelecionavel() {
		FuncionarioSelecionavel funcionarioSelecionavel = new FuncionarioSelecionavel(id, nome, identificacao, cargo, departamento, false);
		return funcionarioSelecionavel;
	}
}
