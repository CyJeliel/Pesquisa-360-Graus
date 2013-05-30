package br.com.idecaph.client.eventos;

import java.util.List;

import br.com.idecaph.shared.Funcionario;

import com.google.gwt.event.shared.GwtEvent;

public class EventoCarregaPesquisa extends
		GwtEvent<EventoCarregaPesquisaHandler> {
	public static Type<EventoCarregaPesquisaHandler> TYPE = new Type<EventoCarregaPesquisaHandler>();
	private List<Funcionario> funcionarios;

	public EventoCarregaPesquisa(List<Funcionario> funcionarios) {
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

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

}
