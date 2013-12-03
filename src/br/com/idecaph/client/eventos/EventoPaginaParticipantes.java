package br.com.idecaph.client.eventos;

import java.util.List;

import br.com.idecaph.client.eventos.handlers.EventoPaginaParticipantesHandler;
import br.com.idecaph.shared.FuncionarioSelecionavel;
import br.com.idecaph.shared.PesquisaClient;

import com.google.gwt.event.shared.GwtEvent;

public class EventoPaginaParticipantes extends
		GwtEvent<EventoPaginaParticipantesHandler> {
	public static Type<EventoPaginaParticipantesHandler> TYPE = new Type<EventoPaginaParticipantesHandler>();
	private PesquisaClient pesquisa;
	private List<FuncionarioSelecionavel> funcionarios;

	public EventoPaginaParticipantes(PesquisaClient pesquisa, List<FuncionarioSelecionavel> funcionarios) {
		this.pesquisa = pesquisa;
		this.funcionarios = funcionarios;
	}

	@Override
	public Type<EventoPaginaParticipantesHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(EventoPaginaParticipantesHandler handler) {
		handler.onEventoPaginaParticipantes(this);
	}

	public PesquisaClient getPesquisa() {
		return pesquisa;
	}

	public List<FuncionarioSelecionavel> getFuncionarios() {
		return funcionarios;
	}
}
