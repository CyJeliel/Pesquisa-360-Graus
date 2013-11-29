package br.com.idecaph.client.eventos;

import java.util.List;

import br.com.idecaph.client.eventos.handlers.EventoCarregaPesquisaHandler;
import br.com.idecaph.shared.FuncionarioClient;

import com.google.gwt.event.shared.GwtEvent;

public class EventoCarregaPesquisa extends
		GwtEvent<EventoCarregaPesquisaHandler> {
	public static Type<EventoCarregaPesquisaHandler> TYPE = new Type<EventoCarregaPesquisaHandler>();
	private List<FuncionarioClient> funcionarios;

	public EventoCarregaPesquisa(List<FuncionarioClient> funcionarios) {
		this.funcionarios = funcionarios;
	}

	@Override
	public Type<EventoCarregaPesquisaHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(EventoCarregaPesquisaHandler handler) {
		handler.onEventoCarregaPesquisa(this);
	}

	public List<FuncionarioClient> getFuncionarios() {
		return funcionarios;
	}

}
