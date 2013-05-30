package br.com.idecaph.client.display;

import br.com.idecaph.shared.FuncionarioSelecionavel;

import com.google.gwt.user.client.ui.HasText;

public interface ResponderPesquisaDisplay extends
		TableDisplay<FuncionarioSelecionavel> {

	HasText getTituloPesquisa();

}
