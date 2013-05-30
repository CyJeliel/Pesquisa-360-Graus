package br.com.idecaph.client.eventos;

import br.com.idecaph.shared.Pesquisa;

import com.google.gwt.event.shared.GwtEvent;

public class EventoPaginaPerguntas extends
		GwtEvent<EventoPaginaPerguntasHandler> {
	public static Type<EventoPaginaPerguntasHandler> TYPE = new Type<EventoPaginaPerguntasHandler>();
	private Pesquisa pesquisa;

	public EventoPaginaPerguntas(Pesquisa pesquisa) {
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

	public Pesquisa getPesquisa() {
		return pesquisa;
	}

}
