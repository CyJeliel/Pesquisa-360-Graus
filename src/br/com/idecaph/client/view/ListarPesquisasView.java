package br.com.idecaph.client.view;

import br.com.idecaph.client.display.ListarPesquisasDisplay;
import br.com.idecaph.shared.PesquisaClient;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;

public class ListarPesquisasView extends TableView<PesquisaClient> implements
		ListarPesquisasDisplay {
	@UiField
	FlexTable tabelaPesquisas;

	private static ListarPesquisasViewUiBinder uiBinder = GWT
			.create(ListarPesquisasViewUiBinder.class);

	interface ListarPesquisasViewUiBinder extends
			UiBinder<Widget, ListarPesquisasView> {
	}

	public ListarPesquisasView() {
		initWidget(uiBinder.createAndBindUi(this));
		super.setTable(tabelaPesquisas);
	}

	public ListarPesquisasView(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
