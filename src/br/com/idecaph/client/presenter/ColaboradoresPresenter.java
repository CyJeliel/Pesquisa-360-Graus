package br.com.idecaph.client.presenter;

import br.com.idecaph.client.display.ColaboradoresDisplay;
import br.com.idecaph.client.interfaces.ColaboradoresService;
import br.com.idecaph.client.interfaces.ColaboradoresServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class ColaboradoresPresenter extends Presenter<ColaboradoresDisplay> {
	ColaboradoresServiceAsync rpcService = GWT
			.create(ColaboradoresService.class);

	public ColaboradoresPresenter(ColaboradoresDisplay display,
			HandlerManager eventBus) {
		super(display, eventBus);
	}

	@Override
	public void bind() {
		final ColaboradoresDisplay display = super.getDisplay();
		HasClickHandlers enviarArquivo = display.getBotaoEnviarArquivo();
		enviarArquivo.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				display.getFormUpload().submit();
			}
		});

		final FormPanel panel = display.getFormUpload();
		panel.setAction("/enviarArquivo");
		panel.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {

			@Override
			public void onSubmitComplete(SubmitCompleteEvent event) {
				// TODO Em constru��o
				Window.alert("Enviou");
			}
		});
		panel.addSubmitHandler(new FormPanel.SubmitHandler() {

			@Override
			public void onSubmit(SubmitEvent event) {
				String filename = display.getFileUpload().getFilename();
				if (filename == null || filename.equals("")) {
					cancelaEvento(event, "Por favor, selecione um arquivo.");
				} else if (!filename.endsWith(".xlsx")) {
					cancelaEvento(event,
							"Formato de arquivo incorreto. Por favor, o arquivo deve ser do tipo xls");
				}
			}

			private void cancelaEvento(SubmitEvent event, String mensagem) {
				Window.alert(mensagem);
				event.cancel();
			}
		});

	}

	@Override
	public void go(final HasWidgets container) {
		bind();
		super.container = container;
		super.container.add(super.getDisplay().getFormUpload());
		super.container
				.add((Widget) super.getDisplay().getBotaoEnviarArquivo());
	}
}
