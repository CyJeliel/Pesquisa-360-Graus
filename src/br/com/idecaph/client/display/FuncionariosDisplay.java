package br.com.idecaph.client.display;

import br.com.idecaph.shared.FuncionarioSelecionavel;

import com.google.gwt.event.dom.client.HasClickHandlers;

public interface FuncionariosDisplay extends
		TableDisplay<FuncionarioSelecionavel> {

	public static final int LISTA_FUNCIONARIOS = 6;

	HasClickHandlers getAcaoNovoFuncionario();

	HasClickHandlers getAcaoNovaPesquisa();

	void exibeFeedback(int excluirFuncionario);

}
