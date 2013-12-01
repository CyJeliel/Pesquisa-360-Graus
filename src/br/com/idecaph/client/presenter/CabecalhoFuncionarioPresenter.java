package br.com.idecaph.client.presenter;

import br.com.idecaph.client.display.CabecalhoDisplay;
import br.com.idecaph.client.eventos.EventoLogout;
import br.com.idecaph.client.eventos.EventoResponderPesquisa;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;

public class CabecalhoFuncionarioPresenter extends Presenter<CabecalhoDisplay> implements CabecalhoPresenter{
	private static HandlerRegistration handler;

	public CabecalhoFuncionarioPresenter(CabecalhoDisplay display, HandlerManager eventBus) {
		super(display, eventBus);
	}

	@Override
	public void bind() {
		CabecalhoDisplay display = super.getDisplay();

		HasClickHandlers responderPesquisa = display.getLinkResponderPesquisa();
		responderPesquisa.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				eventBus.fireEvent(new EventoResponderPesquisa());
			}
		});

		if (handler != null) {
			handler.removeHandler();
		}

		HasClickHandlers logout = display.getLinkLogout();
		handler = logout.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				eventBus.fireEvent(new EventoLogout());
			}
		});
	}

}
