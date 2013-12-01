package br.com.idecaph.client.eventos;

import br.com.idecaph.client.eventos.handlers.EventoResponderPesquisaHandler;
import br.com.idecaph.shared.PesquisaClient;

import com.google.gwt.event.shared.GwtEvent;

public class EventoResponderPesquisa extends
		GwtEvent<EventoResponderPesquisaHandler> {
	public static Type<EventoResponderPesquisaHandler> TYPE = new Type<EventoResponderPesquisaHandler>();
	private PesquisaClient pesquisa;

	public EventoResponderPesquisa(PesquisaClient pesquisa) {
		this.pesquisa = pesquisa;
	}

	@Override
	public Type<EventoResponderPesquisaHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(EventoResponderPesquisaHandler handler) {
		handler.onEventoResponderPesquisa(this);
	}

	public PesquisaClient getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(PesquisaClient pesquisa) {
		this.pesquisa = pesquisa;
	}

}
