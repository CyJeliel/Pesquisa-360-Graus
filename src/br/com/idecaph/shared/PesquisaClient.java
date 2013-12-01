package br.com.idecaph.shared;

import java.util.List;

import br.com.idecaph.client.view.colunas.InformacaoTabela;

import com.google.gwt.user.client.rpc.IsSerializable;

public class PesquisaClient extends InformacaoTabela implements IsSerializable {
	private Long id;
	private Long idUltimaPerguntaRespondida;
	private String titulo;
	private List<FuncionarioSelecionavel> participantes;
	private List<FuncionarioSelecionavel> avaliados;
	private List<PerguntaClient> perguntas;
	private Integer porcentagemPesquisaRespondida;

	public PesquisaClient() {
	}

	public PesquisaClient(String titulo) {
		this.titulo = titulo;
	}

	public PesquisaClient(Long id, String titulo,
			List<FuncionarioSelecionavel> participantes,
			List<FuncionarioSelecionavel> avaliados,
			List<PerguntaClient> perguntas) {
		this.id = id;
		this.titulo = titulo;
		this.participantes = participantes;
		this.avaliados = avaliados;
		this.perguntas = perguntas;
	}

	public String getTitulo() {
		return titulo;
	}

	public List<FuncionarioSelecionavel> getParticipantes() {
		return participantes;
	}

	public List<FuncionarioSelecionavel> getAvaliados() {
		return avaliados;
	}

	public List<PerguntaClient> getPerguntas() {
		return perguntas;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setParticipantes(List<FuncionarioSelecionavel> participantes) {
		this.participantes = participantes;
	}

	public void setAvaliados(List<FuncionarioSelecionavel> avaliados) {
		this.avaliados = avaliados;
	}

	public void setPerguntas(List<PerguntaClient> perguntas) {
		this.perguntas = perguntas;
	}

	public String getDisplayTitulo() {
		return titulo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPorcentagemPesquisaRespondida() {
		return porcentagemPesquisaRespondida;
	}

	public void setPorcentagemPesquisaRespondida(
			Integer porcentagemPesquisaRespondida) {
		this.porcentagemPesquisaRespondida = porcentagemPesquisaRespondida;
	}

	public Long getIdUltimaPerguntaRespondida() {
		return idUltimaPerguntaRespondida;
	}

	public void setIdUltimaPerguntaRespondida(Long idUltimaPerguntaRespondida) {
		this.idUltimaPerguntaRespondida = idUltimaPerguntaRespondida;
	}

}
