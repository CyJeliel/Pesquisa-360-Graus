package br.com.idecaph.model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import br.com.idecaph.shared.RespostaClient;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Resposta implements Entity{
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;

	@Persistent
	private String descricao;
	
	@Persistent
	private Long idParticipante;
	
	@Persistent
	private Long idAvaliado;
	
	@Persistent
	private Long idPesquisa;
	
	@Persistent
	private Long idPergunta;
	
	public Resposta(RespostaClient respostaClient) {
		this.id = respostaClient.getId();
		this.descricao = respostaClient.getDescricao();
		this.idPergunta = respostaClient.getIdPergunta();
		this.idParticipante = respostaClient.getIdParticipante();
		this.idAvaliado = respostaClient.getIdAvaliado();
		this.idPesquisa = respostaClient.getIdPesquisa();
	}

	public Long getIdParticipante() {
		return idParticipante;
	}

	public void setIdParticipante(Long idParticipante) {
		this.idParticipante = idParticipante;
	}

	public Long getIdAvaliado() {
		return idAvaliado;
	}

	public void setIdAvaliado(Long idAvaliado) {
		this.idAvaliado = idAvaliado;
	}

	public Long getIdPesquisa() {
		return idPesquisa;
	}

	public void setIdPesquisa(Long idPesquisa) {
		this.idPesquisa = idPesquisa;
	}

	public Long getIdPergunta() {
		return idPergunta;
	}

	public void setIdPergunta(Long idPergunta) {
		this.idPergunta = idPergunta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
