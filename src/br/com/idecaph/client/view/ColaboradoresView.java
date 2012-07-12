package br.com.idecaph.client.view;

import br.com.idecaph.client.display.ColaboradoresDisplay;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.Widget;

public class ColaboradoresView extends Composite implements
		ColaboradoresDisplay {

	private static ColaboradoresViewUiBinder uiBinder = GWT
			.create(ColaboradoresViewUiBinder.class);

	interface ColaboradoresViewUiBinder extends
			UiBinder<Widget, ColaboradoresView> {
	}

	public ColaboradoresView() {
		initWidget(uiBinder.createAndBindUi(this));
//		botaoEnviarArquivo.setText("Enviar arquivo");
	}

	@UiField
	Button botaoEnviarArquivo;

	@Override
	public HasClickHandlers getBotaoEnviarArquivo() {
		return botaoEnviarArquivo;
	}

	@Override
	public FileUpload getFileUpload() {
		// TODO Auto-generated method stub
		return null;
	}

}
