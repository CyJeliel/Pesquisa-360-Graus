package br.com.idecaph.client.view;

import br.com.idecaph.client.display.CabecalhoDisplay;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;

public class CabecalhoView extends Composite implements CabecalhoDisplay {

	@UiField
	HorizontalPanel cabecalho;
	@UiField
	Anchor responderPesquisa;
	@UiField
	Anchor logout;

	private static CabecalhoUiBinder uiBinder = GWT
			.create(CabecalhoUiBinder.class);

	interface CabecalhoUiBinder extends UiBinder<Widget, CabecalhoView> {
	}

	public CabecalhoView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public Widget asWidget() {
		return cabecalho;
	}

	@Override
	public HasClickHandlers getLinkResponderPesquisa() {
		return responderPesquisa;
	}

	@Override
	public HasClickHandlers getLinkLogout() {
		return logout;
	}

}
