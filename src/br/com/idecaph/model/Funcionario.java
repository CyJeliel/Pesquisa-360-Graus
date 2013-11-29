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
	private String identificacao;

	@Persistent
	private String nome;

	@Persistent
	private String cargo;

	@Persistent
	private String departamento;

	public Funcionario(Long id, String nome, String identificacao,
			String cargo, String departamento) {
		this.id = id;
		this.identificacao = identificacao;
		this.cargo = cargo;
		this.nome = nome;
		this.departamento = departamento;
	}

	public Funcionario(FuncionarioClient funcionarioClient) {
		this.id = funcionarioClient.getId();
		this.identificacao = funcionarioClient.getIdentificacao();
		this.cargo = funcionarioClient.getCargo();
		this.nome = funcionarioClient.getNome();
		this.departamento = funcionarioClient.getDepartamento();
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

	public FuncionarioSelecionavel getFuncionarioSelecionavel() {
		FuncionarioSelecionavel funcionarioSelecionavel = new FuncionarioSelecionavel(id, nome, identificacao, cargo, departamento, false);
		return funcionarioSelecionavel;
	}
}
