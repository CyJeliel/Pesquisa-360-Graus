package br.com.idecaph.client.eventos;

import java.util.List;

import br.com.idecaph.client.eventos.handlers.EventoNovaPesquisaHandler;
import br.com.idecaph.shared.FuncionarioSelecionavel;

import com.google.gwt.event.shared.GwtEvent;

public class EventoNovaPesquisa extends GwtEvent<EventoNovaPesquisaHandler> {
	public static Type<EventoNovaPesquisaHandler> TYPE = new Type<EventoNovaPesquisaHandler>();
	private List<FuncionarioSelecionavel> funcionarios;

	public EventoNovaPesquisa(List<FuncionarioSelecionavel> funcionarios) {
		this.funcionarios = funcionarios;
	}

	@Override
	public Type<EventoNovaPesquisaHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(EventoNovaPesquisaHandler handler) {
		handler.onEventoNovaPesquisa(this);
	}

	public List<FuncionarioSelecionavel> getFuncionarios() {
		return funcionarios;
	}

}
