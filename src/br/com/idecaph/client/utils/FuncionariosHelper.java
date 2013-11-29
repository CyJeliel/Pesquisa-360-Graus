package br.com.idecaph.client.utils;

import java.util.List;

import br.com.idecaph.client.eventos.EventoCarregaFuncionarios;
import br.com.idecaph.client.eventos.EventoExibeFuncionarios;
import br.com.idecaph.client.interfaces.FuncionariosService;
import br.com.idecaph.client.interfaces.FuncionariosServiceAsync;
import br.com.idecaph.shared.FuncionarioClient;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class FuncionariosHelper {
	private static FuncionariosServiceAsync rpcService = GWT
			.create(FuncionariosService.class);
	private HandlerManager eventBus;
	private boolean carregaTelaFuncionarios;

	public FuncionariosHelper(HandlerManager eventBus,
			Boolean carregaTelaFuncionarios) {
		this.eventBus = eventBus;
		this.carregaTelaFuncionarios = carregaTelaFuncionarios;
	}

	public void getFuncionarios() {
		rpcService
				.getFuncionarios(new AsyncCallback<List<FuncionarioClient>>() {

					@Override
					public void onSuccess(List<FuncionarioClient> result) {
						disparaEvento(result);
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}
				});
	}

	private void disparaEvento(List<FuncionarioClient> result) {
		if (carregaTelaFuncionarios) {
			eventBus.fireEvent(new EventoExibeFuncionarios(result));
		} else {
			eventBus.fireEvent(new EventoCarregaFuncionarios(result));
		}
	}
}
