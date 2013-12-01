package br.com.idecaph.client.presenter;

import java.util.List;

import br.com.idecaph.client.display.ListarPesquisasDisplay;
import br.com.idecaph.client.eventos.EventoResponderPesquisa;
import br.com.idecaph.client.view.colunas.PesquisaColunas;
import br.com.idecaph.shared.PesquisaClient;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.Widget;

public class ListarPesquisasPresenter extends Presenter<ListarPesquisasDisplay> {

	private List<PesquisaClient> pesquisas;

	public ListarPesquisasPresenter(ListarPesquisasDisplay display,
			HandlerManager eventBus, List<PesquisaClient> pesquisas) {
		super(display, eventBus);
		this.pesquisas = pesquisas;
	}

	@Override
	public void bind() {

		final ListarPesquisasDisplay display = super.getDisplay();

		display.getLista().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				int linhaSelecionada = display.getLinhaSelecionada(event);

				if (linhaSelecionada > 0) {

					PesquisaClient pesquisa = pesquisas
							.get(linhaSelecionada - 1);

					eventBus.fireEvent(new EventoResponderPesquisa(pesquisa));
				}
			}
		});

		PesquisaColunas pesquisaColunasColunas = new PesquisaColunas();
		display.setColunas(pesquisaColunasColunas.getDefinicoesColunas());
		atualizaTabela();

	}

	private void atualizaTabela() {
		PesquisaClient titulo = new PesquisaClient("<b>PESQUISAS</b>");
		Widget listaVazia = new PesquisaColunas().getColunaListaVazia();
		ListarPesquisasDisplay display = super.getDisplay();
		display.atualizaTabela(pesquisas, titulo, listaVazia);
	}

}
