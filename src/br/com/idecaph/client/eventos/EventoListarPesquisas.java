package br.com.idecaph.client.eventos;

import java.util.List;

import br.com.idecaph.client.eventos.handlers.EventoListarPesquisasHandler;
import br.com.idecaph.shared.PesquisaClient;

import com.google.gwt.event.shared.GwtEvent;

public class EventoListarPesquisas extends
		GwtEvent<EventoListarPesquisasHandler> {
	
	private List<PesquisaClient> pesquisas;
	
	public static Type<EventoListarPesquisasHandler> TYPE = new Type<EventoListarPesquisasHandler>();

	public EventoListarPesquisas(List<PesquisaClient> pesquisas) {
		this.setPesquisas(pesquisas);
	}

	@Override
	public Type<EventoListarPesquisasHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(EventoListarPesquisasHandler handler) {
		handler.onEventoListarPesquisas(this);
	}

	public List<PesquisaClient> getPesquisas() {
		return pesquisas;
	}

	public void setPesquisas(List<PesquisaClient> pesquisas) {
		this.pesquisas = pesquisas;
	}

}
