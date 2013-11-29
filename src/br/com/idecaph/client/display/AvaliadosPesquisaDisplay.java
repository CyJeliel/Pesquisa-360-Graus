package br.com.idecaph.client.display;

import java.util.List;

import br.com.idecaph.shared.FuncionarioSelecionavel;

import com.google.gwt.event.dom.client.HasClickHandlers;

public interface AvaliadosPesquisaDisplay extends
		TableDisplay<FuncionarioSelecionavel> {

	HasClickHandlers getAcaoProximaEtapa();

	void setCheckBoxTituloSelecionado();

	void marcarSelecionados(List<FuncionarioSelecionavel> todos);

}
