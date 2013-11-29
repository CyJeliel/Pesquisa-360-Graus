package br.com.idecaph.client.display;

import java.util.List;

import br.com.idecaph.shared.PerguntaClient;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasText;

public interface PerguntasPesquisaDisplay extends TableDisplay<PerguntaClient> {

	String PERGUNTA_INVALIDA = "A pergunta não pode estar em branco.";
	String PERGUNTA_EXISTENTE = "Essa pergunta já existe nessa pesquisa.";
	int PESQUISA_CADASTRADA = 0;
	int ERRO_CADASTRO_PESQUISA = 1;

	HasClickHandlers getAcaoProximaEtapa();

	void setCheckBoxTituloSelecionado();

	void marcarSelecionados(List<PerguntaClient> perguntas);

	HasClickHandlers getAcaoNovaPergunta();

	HasText getTextNovaPergunta();

	void exibeErro(String tipoErro);

	void exibeFeedback(int excluirFuncionario);

}
