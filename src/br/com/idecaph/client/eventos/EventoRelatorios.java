package br.com.idecaph.client.eventos;

import com.google.gwt.event.shared.GwtEvent;

public class EventoRelatorios extends GwtEvent<EventoRelatoriosHandler> {
	public static Type<EventoRelatoriosHandler> TYPE = new Type<EventoRelatoriosHandler>();

	public EventoRelatorios() {
	}

	@Override
	public Type<EventoRelatoriosHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(EventoRelatoriosHandler handler) {
		handler.onEventoRelatorios(this);
	}

}
