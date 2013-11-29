package br.com.idecaph.client.eventos.handlers;

import br.com.idecaph.client.eventos.EventoPaginaParticipantes;

import com.google.gwt.event.shared.EventHandler;

public interface EventoPaginaParticipantesHandler extends EventHandler{

	void onEventoPaginaParticipantes(
			EventoPaginaParticipantes eventoPaginaParticipantes);

}
