package br.com.idecaph.client.eventos;

import java.util.List;

import br.com.idecaph.client.eventos.handlers.EventoPaginaAvaliadosHandler;
import br.com.idecaph.shared.FuncionarioSelecionavel;
import br.com.idecaph.shared.PesquisaClient;

import com.google.gwt.event.shared.GwtEvent;

public class EventoPaginaAvaliados extends
		GwtEvent<EventoPaginaAvaliadosHandler> {
	public static Type<EventoPaginaAvaliadosHandler> TYPE = new Type<EventoPaginaAvaliadosHandler>();
	private PesquisaClient pesquisa;
	private List<FuncionarioSelecionavel> funcionarios;

	public EventoPaginaAvaliados(PesquisaClient pesquisa, List<FuncionarioSelecionavel> funcionarios) {
		this.pesquisa = pesquisa;
		this.funcionarios = funcionarios;
	}

	@Override
	public Type<EventoPaginaAvaliadosHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(EventoPaginaAvaliadosHandler handler) {
		handler.onEventoAvaliadosPesquisa(this);
	}

	public PesquisaClient getPesquisa() {
		return pesquisa;
	}

	public List<FuncionarioSelecionavel> getFuncionarios() {
		return funcionarios;
	}

}
