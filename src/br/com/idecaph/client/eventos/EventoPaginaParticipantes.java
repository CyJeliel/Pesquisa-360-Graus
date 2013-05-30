package br.com.idecaph.client.eventos;

import br.com.idecaph.shared.Pesquisa;

import com.google.gwt.event.shared.GwtEvent;

public class EventoPaginaParticipantes extends
		GwtEvent<EventoPaginaParticipantesHandler> {
	public static Type<EventoPaginaParticipantesHandler> TYPE = new Type<EventoPaginaParticipantesHandler>();
	private Pesquisa pesquisa;

	public EventoPaginaParticipantes(Pesquisa pesquisa) {
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

	public Pesquisa getPesquisa() {
		return pesquisa;
	}
}
