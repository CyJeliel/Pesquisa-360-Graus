package br.com.idecaph.model;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import br.com.idecaph.shared.FuncionarioSelecionavel;
import br.com.idecaph.shared.PerguntaClient;
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

	public PesquisaClient getPesquisaClient(List<Funcionario> participantes, List<Funcionario> avaliados, List<Pergunta> perguntas) {
		List<FuncionarioSelecionavel> participantesClient = new ArrayList<FuncionarioSelecionavel>();
		for (Funcionario participante: participantes){
			participantesClient.add(participante.getFuncionarioSelecionavel());
		}
		
		List<FuncionarioSelecionavel> avaliadosClient = new ArrayList<FuncionarioSelecionavel>();
		for (Funcionario avaliado: avaliados){
			avaliadosClient.add(avaliado.getFuncionarioSelecionavel());
		}
		
		List<PerguntaClient> perguntasClient = new ArrayList<PerguntaClient>();
		for (Pergunta pergunta: perguntas){
			perguntasClient.add(pergunta.getPerguntaClient());
		}
		
		
		PesquisaClient pesquisaClient = new PesquisaClient(id, nome, participantesClient, avaliadosClient, perguntasClient);
		return pesquisaClient;
	}
}
