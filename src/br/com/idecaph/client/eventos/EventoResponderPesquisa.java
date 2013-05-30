package br.com.idecaph.client.eventos;

import com.google.gwt.event.shared.GwtEvent;

public class EventoResponderPesquisa extends
		GwtEvent<EventoResponderPesquisaHandler> {
	public static Type<EventoResponderPesquisaHandler> TYPE = new Type<EventoResponderPesquisaHandler>();

	@Override
	public Type<EventoResponderPesquisaHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(EventoResponderPesquisaHandler handler) {
		handler.onEventoResponderPesquisa(this);
	}

}
