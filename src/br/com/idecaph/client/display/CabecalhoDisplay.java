package br.com.idecaph.client.display;

import com.google.gwt.event.dom.client.HasClickHandlers;

public interface CabecalhoDisplay extends Display {

	HasClickHandlers getLinkResponderPesquisa();

	public HasClickHandlers getLinkLogout();
}
