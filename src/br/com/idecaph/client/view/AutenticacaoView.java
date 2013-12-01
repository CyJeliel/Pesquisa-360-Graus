package br.com.idecaph.client.view;

import br.com.idecaph.client.display.AutenticacaoDisplay;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CellPanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class AutenticacaoView extends Composite implements AutenticacaoDisplay {
	
	@UiField
	CellPanel body;
	
	@UiField
	TextBox login;
	
	@UiField
	PasswordTextBox senha;
	
	@UiField
	Button botaoLogar;

	private static AutenticacaoViewUiBinder uiBinder = GWT
			.create(AutenticacaoViewUiBinder.class);

	interface AutenticacaoViewUiBinder extends
			UiBinder<Widget, AutenticacaoView> {
	}

	public AutenticacaoView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public CellPanel asWidget() {
		return body;
	}

	@Override
	public HasClickHandlers getAcaoLogin() {
		return botaoLogar;
	}

	@Override
	public HasText getTextLogin() {
		return login;
	}

	@Override
	public HasText getTextSenha() {
		return senha;
	}

}
