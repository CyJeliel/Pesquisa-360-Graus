package br.com.idecaph.client.eventos;

import br.com.idecaph.shared.Pesquisa;

import com.google.gwt.event.shared.GwtEvent;

public class EventoPaginaAvaliados extends
		GwtEvent<EventoPaginaAvaliadosHandler> {
	public static Type<EventoPaginaAvaliadosHandler> TYPE = new Type<EventoPaginaAvaliadosHandler>();
	private Pesquisa pesquisa;

	public EventoPaginaAvaliados(Pesquisa pesquisa) {
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

	public Pesquisa getPesquisa() {
		return pesquisa;
	}

}
