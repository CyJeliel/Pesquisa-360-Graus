package br.com.idecaph.client.eventos;

import br.com.idecaph.client.eventos.handlers.EventoPaginaParticipantesHandler;
import br.com.idecaph.shared.PesquisaClient;

import com.google.gwt.event.shared.GwtEvent;

public class EventoPaginaParticipantes extends
		GwtEvent<EventoPaginaParticipantesHandler> {
	public static Type<EventoPaginaParticipantesHandler> TYPE = new Type<EventoPaginaParticipantesHandler>();
	private PesquisaClient pesquisa;

	public EventoPaginaParticipantes(PesquisaClient pesquisa) {
		this.pesquisa = pesquisa;
	}

	@Override
	public Type<EventoPaginaParticipantesHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(EventoPaginaParticipantesHandler handler) {
		handler.onEventoPaginaParticipantes(this);
	}

	public PesquisaClient getPesquisa() {
		return pesquisa;
	}
}
