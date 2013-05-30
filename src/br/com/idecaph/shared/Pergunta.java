package br.com.idecaph.shared;

import br.com.idecaph.client.view.colunas.InformacaoTabela;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Pergunta extends InformacaoTabela implements IsSerializable {
	private String pergunta;
	private String avaliado;
	private boolean selecionada;

	public Pergunta() {
	}

	public Pergunta(String pergunta, String avaliado) {
		this.pergunta = pergunta;
		this.avaliado = avaliado;
	}

	public String getPergunta() {
		return pergunta;
	}

	public String getAvaliado() {
		return avaliado;
	}
	
	public String getDisplayPergunta() {
		return pergunta;
	}

	public void seleciona() {
		this.selecionada = true;
	}
	
	public boolean isSelecionada() {
		return selecionada;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean retorno = false;
		if (obj instanceof Pergunta){
			Pergunta pergunta = (Pergunta) obj;
			if (pergunta.getPergunta().equals(this.pergunta)){
				retorno = true;
			}
		}
		return retorno;
	}
}
