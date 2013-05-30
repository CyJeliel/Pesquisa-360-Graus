package br.com.idecaph.client.eventos;

import br.com.idecaph.shared.Funcionario;
import br.com.idecaph.shared.Pesquisa;

import com.google.gwt.event.shared.GwtEvent;

public class EventoExibirRelatorio extends
		GwtEvent<EventoExibirRelatorioHandler> {
	private Funcionario funcionario;
	private Pesquisa pesquisa;
	public static Type<EventoExibirRelatorioHandler> TYPE = new Type<EventoExibirRelatorioHandler>();

	public EventoExibirRelatorio(Funcionario funcionario, Pesquisa pesquisa) {
		this.funcionario = funcionario;
		this.pesquisa = pesquisa;
	}

	@Override
	public Type<EventoExibirRelatorioHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(EventoExibirRelatorioHandler handler) {
		handler.onEventoExibirRelatorio(this);
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public Pesquisa getPesquisa() {
		return pesquisa;
	}
}
