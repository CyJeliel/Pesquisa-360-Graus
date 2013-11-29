package br.com.idecaph.client.eventos.handlers;

import br.com.idecaph.client.eventos.EventoPaginaAvaliados;

import com.google.gwt.event.shared.EventHandler;

public interface EventoPaginaAvaliadosHandler extends EventHandler{

	void onEventoAvaliadosPesquisa(
			EventoPaginaAvaliados eventoAvaliadosPesquisa);

}
