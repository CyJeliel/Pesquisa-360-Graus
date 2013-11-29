package br.com.idecaph.model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import br.com.idecaph.shared.PerguntaClient;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Pergunta implements Entity {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;

	@Persistent
	private String pergunta;
	
	@Persistent
	private Long idPesquisa;

	public Pergunta(PerguntaClient perguntaClient, Long idPesquisa) {
		this.pergunta = perguntaClient.getPergunta();
		this.setIdPesquisa(idPesquisa);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public Long getIdPesquisa() {
		return idPesquisa;
	}

	public void setIdPesquisa(Long idPesquisa) {
		this.idPesquisa = idPesquisa;
	}

	public PerguntaClient getPerguntaClient() {
		return new PerguntaClient(id, pergunta);
	}

}
