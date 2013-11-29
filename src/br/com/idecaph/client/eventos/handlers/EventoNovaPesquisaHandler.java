package br.com.idecaph.client.eventos.handlers;

import br.com.idecaph.client.eventos.EventoNovaPesquisa;

import com.google.gwt.event.shared.EventHandler;

public interface EventoNovaPesquisaHandler extends EventHandler{

	void onEventoNovaPesquisa(EventoNovaPesquisa eventoNovaPesquisa);

}
