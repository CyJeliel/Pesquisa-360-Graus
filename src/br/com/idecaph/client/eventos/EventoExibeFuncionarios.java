package br.com.idecaph.client.eventos;

import java.util.List;

import br.com.idecaph.client.eventos.handlers.EventoExibeFuncionariosHandler;
import br.com.idecaph.shared.FuncionarioClient;

import com.google.gwt.event.shared.GwtEvent;

public class EventoExibeFuncionarios extends
		GwtEvent<EventoExibeFuncionariosHandler> {
	public static Type<EventoExibeFuncionariosHandler> TYPE = new Type<EventoExibeFuncionariosHandler>();
	private List<FuncionarioClient> funcionarios;

	public EventoExibeFuncionarios(List<FuncionarioClient> funcionarios) {
		this.funcionarios = funcionarios;
	}

	@Override
	public Type<EventoExibeFuncionariosHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(EventoExibeFuncionariosHandler handler) {
		handler.onEventoExibeFuncionarios(this);
	}

	public List<FuncionarioClient> getFuncionarios() {
		return funcionarios;
	}
}
