package br.com.idecaph.client.eventos;

import java.util.List;

import br.com.idecaph.client.eventos.handlers.EventoExibirRelatorioHandler;
import br.com.idecaph.shared.FuncionarioClient;
import br.com.idecaph.shared.RelatorioClient;

import com.google.gwt.event.shared.GwtEvent;

public class EventoExibirRelatorio extends
		GwtEvent<EventoExibirRelatorioHandler> {
	private FuncionarioClient funcionario;
	private List<RelatorioClient> relatorios;
	public static Type<EventoExibirRelatorioHandler> TYPE = new Type<EventoExibirRelatorioHandler>();

	public EventoExibirRelatorio(FuncionarioClient funcionario,
			List<RelatorioClient> relatorios) {
		this.funcionario = funcionario;
		this.relatorios = relatorios;
	}

	@Override
	public Type<EventoExibirRelatorioHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(EventoExibirRelatorioHandler handler) {
		handler.onEventoExibirRelatorio(this);
	}

	public FuncionarioClient getFuncionario() {
		return funcionario;
	}

	public List<RelatorioClient> getRelatorios() {
		return relatorios;
	}
}
