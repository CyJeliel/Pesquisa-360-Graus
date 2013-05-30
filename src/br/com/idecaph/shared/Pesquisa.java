package br.com.idecaph.shared;

import java.util.List;

import br.com.idecaph.client.view.colunas.InformacaoTabela;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Pesquisa extends InformacaoTabela implements IsSerializable {
	private String titulo;
	private List<FuncionarioSelecionavel> participantes;
	private List<FuncionarioSelecionavel> avaliados;
	private List<Pergunta> perguntas;
	
	public Pesquisa() {
	}

	public Pesquisa(String titulo, List<FuncionarioSelecionavel> participantes, List<FuncionarioSelecionavel> avaliados, List<Pergunta> perguntas){
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

	public List<Pergunta> getPerguntas() {
		return perguntas;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setParticipantes(
			List<FuncionarioSelecionavel> participantes) {
		this.participantes = participantes;
	}

	public void setAvaliados(
			List<FuncionarioSelecionavel> avaliados) {
		this.avaliados = avaliados;
	}

	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}

	public String getDisplayTitulo() {
		return titulo;
	}

}
