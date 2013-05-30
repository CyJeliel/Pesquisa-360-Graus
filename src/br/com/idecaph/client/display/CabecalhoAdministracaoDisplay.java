package br.com.idecaph.client.display;

import com.google.gwt.event.dom.client.HasClickHandlers;

public interface CabecalhoAdministracaoDisplay extends Display {
//	public HasClickHandlers getLogoIdecaph();

	public HasClickHandlers getLinkFuncionarios();

	public HasClickHandlers getLinkPesquisas();

	HasClickHandlers getLinkRelatorios();

	HasClickHandlers getLinkResponderPesquisa();
}
