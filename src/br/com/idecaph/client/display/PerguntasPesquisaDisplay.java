package br.com.idecaph.client.display;

import java.util.List;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasText;

import br.com.idecaph.shared.Pergunta;

public interface PerguntasPesquisaDisplay extends TableDisplay<Pergunta>{

	String PERGUNTA_INVALIDA = "A pergunta não pode estar em branco.";
	String PERGUNTA_EXISTENTE = "Essa pergunta já existe nessa pesquisa.";

	HasClickHandlers getAcaoProximaEtapa();

	void setCheckBoxTituloSelecionado();

	void marcarSelecionados(List<Pergunta> perguntas);

	HasClickHandlers getAcaoNovaPergunta();
	
	HasText getTextNovaPergunta();

	void exibeErro(String tipoErro);

}
