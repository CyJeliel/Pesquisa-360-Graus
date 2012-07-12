package br.com.idecaph.client;

import br.com.idecaph.client.interfaces.ColaboradoresService;
import br.com.idecaph.client.interfaces.ColaboradoresServiceAsync;
import br.com.idecaph.client.presenter.ColaboradoresPresenter;
import br.com.idecaph.client.view.ColaboradoresView;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Idecaph implements EntryPoint {
	public void onModuleLoad() {
		ColaboradoresServiceAsync rpcService = GWT
				.create(ColaboradoresService.class);
		HandlerManager eventBus = new HandlerManager(null);
		ColaboradoresPresenter presenter = new ColaboradoresPresenter(
				rpcService, eventBus, new ColaboradoresView());
		presenter.go(RootPanel.get());
	}
}
