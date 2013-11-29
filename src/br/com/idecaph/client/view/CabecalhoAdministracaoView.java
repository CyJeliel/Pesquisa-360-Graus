package br.com.idecaph.client.view;

import br.com.idecaph.client.display.CabecalhoAdministracaoDisplay;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;

public class CabecalhoAdministracaoView extends Composite implements
		CabecalhoAdministracaoDisplay {

	// @UiField
	// Image logoIdecaph;
	@UiField
	HorizontalPanel cabecalho;
	@UiField
	Anchor funcionarios;
	@UiField
	Anchor pesquisas;
	@UiField
	Anchor relatorios;
	@UiField
	Anchor responderPesquisa;

	private static CabecalhoAdministracaoUiBinder uiBinder = GWT
			.create(CabecalhoAdministracaoUiBinder.class);

	interface CabecalhoAdministracaoUiBinder extends
			UiBinder<Widget, CabecalhoAdministracaoView> {
	}

	public CabecalhoAdministracaoView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	// public HasClickHandlers getLogoIdecaph () {
	// return logoIdecaph;
	// }

	public HasClickHandlers getLinkFuncionarios() {
		return funcionarios;
	}

	@Override
	public HasClickHandlers getLinkPesquisas() {
		return pesquisas;
	}

	@Override
	public HasClickHandlers getLinkRelatorios() {
		return relatorios;
	}

	@Override
	public HasClickHandlers getLinkResponderPesquisa() {
		return responderPesquisa;
	}

	@Override
	public Widget asWidget() {
		return cabecalho;
	}

}
