package br.com.idecaph.client.eventos;

import br.com.idecaph.client.eventos.handlers.EventoResponderPesquisaFuncionarioHandler;
import br.com.idecaph.shared.FuncionarioClient;
import br.com.idecaph.shared.PesquisaClient;

import com.google.gwt.event.shared.GwtEvent;

public class EventoResponderPesquisaFuncionario extends
		GwtEvent<EventoResponderPesquisaFuncionarioHandler> {
	public static Type<EventoResponderPesquisaFuncionarioHandler> TYPE = new Type<EventoResponderPesquisaFuncionarioHandler>();
	private FuncionarioClient funcionario;
	private PesquisaClient pesquisa;

	public EventoResponderPesquisaFuncionario(FuncionarioClient funcionario,
			PesquisaClient pesquisa) {
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

	public FuncionarioClient getFuncionario() {
		return funcionario;
	}

	public PesquisaClient getPesquisa() {
		return pesquisa;
	}

}
