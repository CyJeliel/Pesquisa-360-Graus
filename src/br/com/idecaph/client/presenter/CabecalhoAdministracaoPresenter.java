package br.com.idecaph.client.presenter;

import br.com.idecaph.client.display.CabecalhoAdministracaoDisplay;
import br.com.idecaph.client.eventos.EventoNovaPesquisa;
import br.com.idecaph.client.eventos.EventoRelatorios;
import br.com.idecaph.client.eventos.EventoResponderPesquisa;
import br.com.idecaph.client.utils.FuncionariosHelper;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;

public class CabecalhoAdministracaoPresenter extends
		Presenter<CabecalhoAdministracaoDisplay> {
	public CabecalhoAdministracaoPresenter(
			CabecalhoAdministracaoDisplay display, HandlerManager eventBus) {
		super(display, eventBus);
	}

	@Override
	public void bind() {
		CabecalhoAdministracaoDisplay display = super.getDisplay();

		HasClickHandlers funcionarios = display.getLinkFuncionarios();
		funcionarios.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				carregaTelaFuncionarios();
			}
		});

		HasClickHandlers pesquisas = display.getLinkPesquisas();
		pesquisas.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				eventBus.fireEvent(new EventoNovaPesquisa(null));
			}
		});
		
		HasClickHandlers relatorios = display.getLinkRelatorios();
		relatorios.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				eventBus.fireEvent(new EventoRelatorios());
			}
		});
		
		HasClickHandlers responderPesquisa = display.getLinkResponderPesquisa();
		responderPesquisa.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				eventBus.fireEvent(new EventoResponderPesquisa());
			}
		});
	}

	private void carregaTelaFuncionarios() {
		FuncionariosHelper helper = new FuncionariosHelper(eventBus, true);
		helper.getFuncionarios();
	}

}
