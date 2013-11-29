package br.com.idecaph.model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class AvaliadoPesquisa implements Entity {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private Long idFuncionario;
	@Persistent
	private Long idPesquisa;

	public AvaliadoPesquisa() {
	}

	public AvaliadoPesquisa(Long idFuncionario, Long idPesquisa) {
		this.idFuncionario = idFuncionario;
		this.idPesquisa = idPesquisa;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public Long getIdPesquisa() {
		return idPesquisa;
	}

	public void setIdPesquisa(Long idPesquisa) {
		this.idPesquisa = idPesquisa;
	}
}
