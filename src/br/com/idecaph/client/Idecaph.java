package br.com.idecaph.client;

import br.com.idecaph.client.presenter.CabecalhoAdministracaoPresenter;
import br.com.idecaph.client.presenter.ConteudoPresenter;
import br.com.idecaph.client.view.CabecalhoAdministracaoView;
import br.com.idecaph.client.view.ConteudoView;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Idecaph implements EntryPoint {
	public void onModuleLoad() {
		HandlerManager eventBus = new HandlerManager(null);
		CabecalhoAdministracaoPresenter cabecalhoPresenter = new CabecalhoAdministracaoPresenter(
				new CabecalhoAdministracaoView(), eventBus);
		cabecalhoPresenter.go(RootPanel.get());
		ConteudoPresenter conteudoPresenter = new ConteudoPresenter(new ConteudoView(), eventBus);
		conteudoPresenter.go(RootPanel.get());
		// ColaboradoresPresenter presenter = new ColaboradoresPresenter(
		// new ColaboradoresView());
		// presenter.go(RootPanel.get());
	}
}
