package br.com.idecaph.client.display;

import java.util.List;

import br.com.idecaph.shared.FuncionarioSelecionavel;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasText;

public interface RelatoriosDisplay extends
		TableDisplay<FuncionarioSelecionavel> {

	void setPesquisasExistentes(List<String> pesquisasExistentes);

	HasClickHandlers getAcaoExibirRelatorio();

	HasText getBoxTituloPesquisa();

	void exibeErro(int tipoErro);

}
