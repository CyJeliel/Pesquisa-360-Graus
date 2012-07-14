package br.com.idecaph.client.presenter;

import br.com.idecaph.client.display.Display;
import br.com.idecaph.client.interfaces.ColaboradoresServiceAsync;
import br.com.idecaph.client.view.ColaboradoresView;

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

public class ColaboradoresPresenter implements Presenter {

	ColaboradoresView display;
	private HasWidgets container;

	public ColaboradoresPresenter(ColaboradoresServiceAsync rpcService,
			HandlerManager eventBus, Display display) {
		if (display instanceof ColaboradoresView) {
			this.display = (ColaboradoresView) display;
		} else {
			throw new UnsupportedOperationException(
					"Display não é do tipo ColaboradoresView");
		}
		bind();
	}

	private void bind() {
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
				// TODO Em construção
				Window.alert("Enviou");
			}
		});
		panel.addSubmitHandler(new FormPanel.SubmitHandler() {

			@Override
			public void onSubmit(SubmitEvent event) {
				String filename = display.getFileUpload().getFilename();
				if (filename == null || filename.equals("")){
					cancelaEvento(event, "Por favor, selecione um arquivo.");
				} else if (!filename.endsWith(".xls")){
					cancelaEvento(event, "Formato de arquivo incorreto. Por favor, o arquivo deve ser do tipo xls");
				}
			}

			private void cancelaEvento(SubmitEvent event, String mensagem) {
				Window.alert(mensagem);
				event.cancel();
			}
		});

	}

	public void go(final HasWidgets container) {
		this.container = container;
		this.container.add(display.getFormUpload());
		this.container.add((Widget) display.getBotaoEnviarArquivo());
	}
}
