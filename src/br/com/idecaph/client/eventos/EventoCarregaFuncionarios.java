package br.com.idecaph.client.eventos;

import java.util.List;

import br.com.idecaph.client.eventos.handlers.EventoCarregaFuncionariosHandler;
import br.com.idecaph.shared.FuncionarioClient;

import com.google.gwt.event.shared.GwtEvent;

public class EventoCarregaFuncionarios extends
		GwtEvent<EventoCarregaFuncionariosHandler> {
	public static Type<EventoCarregaFuncionariosHandler> TYPE = new Type<EventoCarregaFuncionariosHandler>();
	private List<FuncionarioClient> funcionarios;

	public EventoCarregaFuncionarios(List<FuncionarioClient> funcionarios) {
		this.funcionarios = funcionarios;
	}

	@Override
	public Type<EventoCarregaFuncionariosHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(EventoCarregaFuncionariosHandler handler) {
		handler.onEventoCarregaFuncionarios(this);
	}

	public List<FuncionarioClient> getFuncionarios() {
		return funcionarios;
	}

}
