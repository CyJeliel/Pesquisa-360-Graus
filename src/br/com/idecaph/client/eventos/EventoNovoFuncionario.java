package br.com.idecaph.client.eventos;

import br.com.idecaph.client.eventos.handlers.EventoNovoFuncionarioHandler;

import com.google.gwt.event.shared.GwtEvent;

public class EventoNovoFuncionario extends
		GwtEvent<EventoNovoFuncionarioHandler> {
	public static Type<EventoNovoFuncionarioHandler> TYPE = new Type<EventoNovoFuncionarioHandler>();

	@Override
	public Type<EventoNovoFuncionarioHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(EventoNovoFuncionarioHandler handler) {
		handler.onEventoNovoFuncionario(this);
	}

}
