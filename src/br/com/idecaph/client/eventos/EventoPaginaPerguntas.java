package br.com.idecaph.client.eventos;

import br.com.idecaph.client.eventos.handlers.EventoPaginaPerguntasHandler;
import br.com.idecaph.shared.PesquisaClient;

import com.google.gwt.event.shared.GwtEvent;

public class EventoPaginaPerguntas extends
		GwtEvent<EventoPaginaPerguntasHandler> {
	public static Type<EventoPaginaPerguntasHandler> TYPE = new Type<EventoPaginaPerguntasHandler>();
	private PesquisaClient pesquisa;

	public EventoPaginaPerguntas(PesquisaClient pesquisa) {
		this.pesquisa = pesquisa;
	}

	@Override
	public Type<EventoPaginaPerguntasHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(EventoPaginaPerguntasHandler handler) {
		handler.onEventoPaginaPerguntas(this);
	}

	public PesquisaClient getPesquisa() {
		return pesquisa;
	}

}
