package br.com.idecaph.client.eventos;

import java.util.List;

import br.com.idecaph.shared.Funcionario;

import com.google.gwt.event.shared.GwtEvent;

public class EventoCarregaFuncionarios extends
		GwtEvent<EventoCarregaFuncionariosHandler> {
	public static Type<EventoCarregaFuncionariosHandler> TYPE = new Type<EventoCarregaFuncionariosHandler>();
	private List<Funcionario> funcionarios;

	public EventoCarregaFuncionarios(List<Funcionario> funcionarios) {
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

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

}
