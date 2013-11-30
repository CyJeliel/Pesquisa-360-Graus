package br.com.idecaph.client;

import br.com.idecaph.client.presenter.AutenticacaoPresenter;
import br.com.idecaph.client.view.AutenticacaoView;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.shared.HandlerManager;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Idecaph implements EntryPoint {
	public void onModuleLoad() {
		HandlerManager eventBus = new HandlerManager(null);

		AutenticacaoPresenter autenticacaoPresenter = new AutenticacaoPresenter(
				new AutenticacaoView(), eventBus);

		autenticacaoPresenter.carregaPaginaInicial(true);

		// ColaboradoresPresenter presenter = new ColaboradoresPresenter(
		// new ColaboradoresView());
		// presenter.go(RootPanel.get());
	}
}
