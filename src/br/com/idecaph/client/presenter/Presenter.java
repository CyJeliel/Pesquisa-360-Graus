package br.com.idecaph.client.presenter;

import br.com.idecaph.client.display.Display;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;

public abstract class Presenter<T extends Display> {
	protected HasWidgets container;
	private T display;
	protected HandlerManager eventBus;

	public Presenter(T display, HandlerManager eventBus) {
		this.display = display;
		this.eventBus = eventBus;
	}

	public abstract void bind();

	public void go(HasWidgets container) {
		bind();
		this.container = container;
		this.container.add(display.asWidget());
	}

	protected T getDisplay() {
		return display;
	}

}
