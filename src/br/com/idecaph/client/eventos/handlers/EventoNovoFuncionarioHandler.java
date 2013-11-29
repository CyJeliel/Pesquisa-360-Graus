package br.com.idecaph.client.eventos.handlers;

import br.com.idecaph.client.eventos.EventoNovoFuncionario;

import com.google.gwt.event.shared.EventHandler;

public interface EventoNovoFuncionarioHandler extends EventHandler {

	void onEventoNovoFuncionario(EventoNovoFuncionario eventoNovoFuncionario);

}
