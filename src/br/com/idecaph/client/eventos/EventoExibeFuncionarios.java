package br.com.idecaph.client.eventos;

import java.util.List;

import br.com.idecaph.shared.Funcionario;

import com.google.gwt.event.shared.GwtEvent;

public class EventoExibeFuncionarios extends
		GwtEvent<EventoExibeFuncionariosHandler> {
	public static Type<EventoExibeFuncionariosHandler> TYPE = new Type<EventoExibeFuncionariosHandler>();
	private List<Funcionario> funcionarios;

	public EventoExibeFuncionarios(List<Funcionario> funcionarios) {
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

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
}
