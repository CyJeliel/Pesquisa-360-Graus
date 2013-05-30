package br.com.idecaph.client.eventos;

import br.com.idecaph.shared.Funcionario;
import br.com.idecaph.shared.Pesquisa;

import com.google.gwt.event.shared.GwtEvent;

public class EventoResponderPesquisaFuncionario extends
		GwtEvent<EventoResponderPesquisaFuncionarioHandler> {
	public static Type<EventoResponderPesquisaFuncionarioHandler> TYPE = new Type<EventoResponderPesquisaFuncionarioHandler>();
	private Funcionario funcionario;
	private Pesquisa pesquisa;

	public EventoResponderPesquisaFuncionario(Funcionario funcionario, Pesquisa pesquisa) {
		this.funcionario = funcionario;
		this.pesquisa = pesquisa;
	}

	@Override
	public Type<EventoResponderPesquisaFuncionarioHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(EventoResponderPesquisaFuncionarioHandler handler) {
		handler.onEventoResponderPesquisaFuncionario(this);
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public Pesquisa getPesquisa() {
		return pesquisa;
	}

}
