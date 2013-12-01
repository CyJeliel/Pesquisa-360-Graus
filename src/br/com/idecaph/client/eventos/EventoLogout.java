package br.com.idecaph.client.eventos;

import br.com.idecaph.client.eventos.handlers.EventoLogoutHandler;

import com.google.gwt.event.shared.GwtEvent;

public class EventoLogout extends GwtEvent<EventoLogoutHandler> {
	public static Type<EventoLogoutHandler> TYPE = new Type<EventoLogoutHandler>();

	@Override
	public Type<EventoLogoutHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(EventoLogoutHandler handler) {
		handler.onEventoLogout(this);
	}

}
