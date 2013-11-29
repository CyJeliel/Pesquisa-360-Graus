package br.com.idecaph.model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import br.com.idecaph.shared.PesquisaClient;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Pesquisa implements Entity {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;

	@Persistent
	private String nome;

	public Pesquisa() {
	}

	public Pesquisa(PesquisaClient pesquisaClient) {
		this.nome = pesquisaClient.getTitulo();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
