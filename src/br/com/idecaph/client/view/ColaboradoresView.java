package br.com.idecaph.client.view;

import br.com.idecaph.client.display.ColaboradoresDisplay;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class ColaboradoresView extends Composite implements
		ColaboradoresDisplay {
	
	private FormPanel form;
	private FileUpload upload;
	
	private static ColaboradoresViewUiBinder uiBinder = GWT
			.create(ColaboradoresViewUiBinder.class);

	interface ColaboradoresViewUiBinder extends
			UiBinder<Widget, ColaboradoresView> {
	}

	public ColaboradoresView() {
		initWidget(uiBinder.createAndBindUi(this));
		iniciaCampoUpload();
	}

	@UiField
	Button botaoEnviarArquivo;

	@Override
	public HasClickHandlers getBotaoEnviarArquivo() {
		return botaoEnviarArquivo;
	}

	@Override
	public FormPanel getFormUpload() {
		return form;
	}

	private void iniciaCampoUpload() {
		form = new FormPanel();
		form.setEncoding(FormPanel.ENCODING_MULTIPART);
		form.setMethod(FormPanel.METHOD_POST);
		form.setWidth("275px");

		VerticalPanel holder = new VerticalPanel();
		upload = new FileUpload();
		upload.setName("upload");
		holder.add(upload);
		holder.add(botaoEnviarArquivo);
		form.add(holder);
	}

	@Override
	public FileUpload getFileUpload() {
		return upload;
	}

	@Override
	public Widget asWidget() {
		return super.asWidget();
	}
}
