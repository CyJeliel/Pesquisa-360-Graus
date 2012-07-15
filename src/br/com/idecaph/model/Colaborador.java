package br.com.idecaph.model;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Colaborador {
	@Persistent
	private String cargo;

	@Persistent
	private String nome;

	@PrimaryKey
	@Persistent
	private String email;
	
	@Persistent
	private String area;

	@Persistent
	private String departamento;

	@Persistent
	private String escolaridade;

	@Persistent
	private String sexo;

	@Persistent
	private String telefone;

	@Persistent
	private String celular;

	@Persistent
	private String cpf;

	@Persistent
	private Double dataAdmissao;

	@Persistent
	private Double dataDemissao;

	public String getCargo() {
		return cargo;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getArea() {
		return area;
	}

	public String getDepartamento() {
		return departamento;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public String getSexo() {
		return sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCelular() {
		return celular;
	}

	public String getCpf() {
		return cpf;
	}

	public Double getDataAdmissao() {
		return dataAdmissao;
	}

	public Double getDataDemissao() {
		return dataDemissao;
	}

}
