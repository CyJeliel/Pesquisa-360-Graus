package br.com.idecaph.client.eventos.handlers;

import br.com.idecaph.client.eventos.EventoCarregaFuncionarios;

import com.google.gwt.event.shared.EventHandler;

public interface EventoCarregaFuncionariosHandler extends EventHandler{

	void onEventoCarregaFuncionarios(
			EventoCarregaFuncionarios eventoCarregaFuncionarios);

}
