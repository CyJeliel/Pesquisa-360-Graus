package br.com.idecaph.client.eventos;

import br.com.idecaph.client.eventos.handlers.EventoEditarFuncionarioHandler;
import br.com.idecaph.shared.FuncionarioClient;

import com.google.gwt.event.shared.GwtEvent;

public class EventoEditarFuncionario extends
		GwtEvent<EventoEditarFuncionarioHandler> {
	public static Type<EventoEditarFuncionarioHandler> TYPE = new Type<EventoEditarFuncionarioHandler>();
	private FuncionarioClient funcionario;

	public EventoEditarFuncionario(FuncionarioClient funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public Type<EventoEditarFuncionarioHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(EventoEditarFuncionarioHandler handler) {
		handler.onEventoEditarFuncionario(this);
	}

	public FuncionarioClient getFuncionario() {
		return funcionario;
	}

}
