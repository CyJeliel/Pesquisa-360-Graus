package br.com.idecaph.client.eventos.handlers;

import br.com.idecaph.client.eventos.EventoResponderPesquisa;

import com.google.gwt.event.shared.EventHandler;

public interface EventoResponderPesquisaHandler extends EventHandler{

	void onEventoResponderPesquisa(
			EventoResponderPesquisa eventoResponderPesquisa);

}
