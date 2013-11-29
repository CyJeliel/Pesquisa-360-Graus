package br.com.idecaph.client.display;

import br.com.idecaph.shared.FuncionarioSelecionavel;

import com.google.gwt.event.dom.client.HasClickHandlers;

public interface FuncionariosDisplay extends
		TableDisplay<FuncionarioSelecionavel> {

	public static final int LISTA_FUNCIONARIOS = 1;

	public static final int EXCLUIR_FUNCIONARIO = 2;

	public static final int ERRO_EXCLUIR_FUNCIONARIO = 3;

	HasClickHandlers getAcaoNovoFuncionario();

	HasClickHandlers getAcaoNovaPesquisa();

	void exibeFeedback(int excluirFuncionario);

}
