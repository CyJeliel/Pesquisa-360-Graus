package br.com.idecaph.shared;

import java.util.Map;

import com.google.gwt.user.client.rpc.IsSerializable;

public class RelatorioClient implements IsSerializable {
	private PerguntaClient perguntaClient;
	private Map<String, Integer> porcentagensRspostas;

	public RelatorioClient() {
	}
	
	public RelatorioClient(PerguntaClient pergunta,
			Map<String, Integer> porcentagensRespostas) {
		this.perguntaClient = pergunta;
		this.setPorcentagensRspostas(porcentagensRespostas);
	}

	public PerguntaClient getPerguntaClient() {
		return perguntaClient;
	}

	public void setPerguntaClient(PerguntaClient perguntaClient) {
		this.perguntaClient = perguntaClient;
	}

	public Map<String, Integer> getPorcentagensRespostas() {
		return porcentagensRspostas;
	}

	public void setPorcentagensRspostas(
			Map<String, Integer> porcentagensRspostas) {
		this.porcentagensRspostas = porcentagensRspostas;
	}
}