package br.com.idecaph.client.eventos;

import br.com.idecaph.client.eventos.handlers.EventoPaginaAvaliadosHandler;
import br.com.idecaph.shared.PesquisaClient;

import com.google.gwt.event.shared.GwtEvent;

public class EventoPaginaAvaliados extends
		GwtEvent<EventoPaginaAvaliadosHandler> {
	public static Type<EventoPaginaAvaliadosHandler> TYPE = new Type<EventoPaginaAvaliadosHandler>();
	private PesquisaClient pesquisa;

	public EventoPaginaAvaliados(PesquisaClient pesquisa) {
		this.pesquisa = pesquisa;
	}

	@Override
	public Type<EventoPaginaAvaliadosHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(EventoPaginaAvaliadosHandler handler) {
		handler.onEventoAvaliadosPesquisa(this);
	}

	public PesquisaClient getPesquisa() {
		return pesquisa;
	}

}
