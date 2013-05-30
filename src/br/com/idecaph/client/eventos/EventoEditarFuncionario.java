package br.com.idecaph.client.eventos;

import br.com.idecaph.shared.Funcionario;

import com.google.gwt.event.shared.GwtEvent;

public class EventoEditarFuncionario extends
		GwtEvent<EventoEditarFuncionarioHandler> {
	public static Type<EventoEditarFuncionarioHandler> TYPE = new Type<EventoEditarFuncionarioHandler>();
	private Funcionario funcionario;

	public EventoEditarFuncionario(Funcionario funcionario) {
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

	public Funcionario getFuncionario() {
		return funcionario;
	}

}
