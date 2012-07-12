package br.com.idecaph.client.presenter;

import br.com.idecaph.client.display.Display;
import br.com.idecaph.client.interfaces.ColaboradoresServiceAsync;
import br.com.idecaph.client.view.ColaboradoresView;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class ColaboradoresPresenter implements Presenter {

	ColaboradoresView display;
	private HasWidgets container;

	public ColaboradoresPresenter(ColaboradoresServiceAsync rpcService,
			HandlerManager eventBus,
			Display display) {
		if (display instanceof ColaboradoresView) {
			this.display = (ColaboradoresView) display;
		} else {
			throw new UnsupportedOperationException(
					"Display n‹o Ž do tipo ColaboradoresView");
		}
		bind();
	}

	private void bind() {
		HasClickHandlers enviarArquivo = this.display.getBotaoEnviarArquivo();
		enviarArquivo.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Window.alert("Hello!");
			}
		});
	}
	
	public void go(final HasWidgets container) {
		this.container = container;
		this.container.add((Widget) display.getBotaoEnviarArquivo());
	}
}
