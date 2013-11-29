package br.com.idecaph.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class RespostaClient implements IsSerializable {
	private Long id;
	private String descricao;
	private Long idPergunta;
	private Long idParticipante;
	private Long idAvaliado;
	private Long idPesquisa;
	private Integer porcentagemRespostas;
	
	public RespostaClient() {
	}
	
	public RespostaClient(Long id, String descricao, Long idPergunta,
			Long idParticipante, Long idAvaliado, Long idPesquisa) {
		this.id = id;
		this.descricao = descricao;
		this.idPergunta = idPergunta;
		this.idParticipante = idParticipante;
		this.idAvaliado = idAvaliado;
		this.idPesquisa = idPesquisa;
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
	public Long getIdPergunta() {
		return idPergunta;
	}
	public void setIdPergunta(Long idPergunta) {
		this.idPergunta = idPergunta;
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

	public Integer getPorcentagemRespostas() {
		return porcentagemRespostas;
	}

	public void setPorcentagemRespostas(Integer porcentagemRespostas) {
		this.porcentagemRespostas = porcentagemRespostas;
	}
	
}
