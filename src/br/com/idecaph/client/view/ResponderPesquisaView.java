package br.com.idecaph.client.view;

import br.com.idecaph.client.display.ResponderPesquisaDisplay;
import br.com.idecaph.shared.FuncionarioSelecionavel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class ResponderPesquisaView extends TableView<FuncionarioSelecionavel>
		implements ResponderPesquisaDisplay {

	@UiField
	FlexTable tabelaAvaliados;
	@UiField
	Label titulo;
	@UiField
	Label porcentagemTotal;

	private static ResponderPesquisaViewUiBinder uiBinder = GWT
			.create(ResponderPesquisaViewUiBinder.class);

	interface ResponderPesquisaViewUiBinder extends
			UiBinder<Widget, ResponderPesquisaView> {
	}

	public ResponderPesquisaView() {
		initWidget(uiBinder.createAndBindUi(this));
		super.setTable(tabelaAvaliados);
	}

	@Override
	public HasText getTituloPesquisa() {
		return titulo;
	}

	@Override
	public HasText getTotalRespondido() {
		return porcentagemTotal;
	}

}
