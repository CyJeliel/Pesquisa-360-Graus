package br.com.idecaph.client.eventos.handlers;

import br.com.idecaph.client.eventos.EventoLogout;

import com.google.gwt.event.shared.EventHandler;

public interface EventoLogoutHandler extends EventHandler {

	void onEventoLogout(EventoLogout eventoLogout);

}