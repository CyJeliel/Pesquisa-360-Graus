package br.com.idecaph.client.presenter;

import java.util.List;

import br.com.idecaph.client.display.ResponderPesquisaDisplay;
import br.com.idecaph.client.eventos.EventoResponderPesquisaFuncionario;
import br.com.idecaph.client.interfaces.PesquisaService;
import br.com.idecaph.client.interfaces.PesquisaServiceAsync;
import br.com.idecaph.client.view.colunas.AvaliadoPorcentagemColunas;
import br.com.idecaph.shared.Funcionario;
import br.com.idecaph.shared.FuncionarioSelecionavel;
import br.com.idecaph.shared.Pesquisa;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;

public class ResponderPesquisaPresenter extends
		Presenter<ResponderPesquisaDisplay> {
	private PesquisaServiceAsync rpcService = GWT.create(PesquisaService.class);
	private Pesquisa pesquisa;

	public ResponderPesquisaPresenter(ResponderPesquisaDisplay display,
			HandlerManager eventBus) {
		super(display, eventBus);
	}

	@Override
	public void bind() {

		rpcService.getPesquisa(new AsyncCallback<Pesquisa>() {

			@Override
			public void onSuccess(Pesquisa result) {
				pesquisa = result;
				atualizaTitulo();
				atualizaTabela();
				addHandlers();
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}
		});
	}

	protected void atualizaTitulo() {
		final ResponderPesquisaDisplay display = getResponderPesquisaDisplay();
		display.getTituloPesquisa().setText(pesquisa.getDisplayTitulo());
	}

	protected void atualizaTabela() {
		final ResponderPesquisaDisplay display = getResponderPesquisaDisplay();
		AvaliadoPorcentagemColunas colunas = new AvaliadoPorcentagemColunas();
		display.setColunas(colunas.getColunas());
		FuncionarioSelecionavel titulo = new FuncionarioSelecionavel(
				"<b>FUNCIONÁRIOS AVALIADOS</b>", "<b>IDENTIFICAÇÃO</b>",
				"<b>CARGO</b>", "<b>DEPARTAMENTO</b>", false);
		Widget listaVazia = new AvaliadoPorcentagemColunas().getColunaListaVazia();
		List<FuncionarioSelecionavel> avaliados = pesquisa.getAvaliados();
		display.atualizaTabela(avaliados, titulo, listaVazia);
	}

	private ResponderPesquisaDisplay getResponderPesquisaDisplay() {
		return super.getDisplay();
	}

	private void addHandlers() {
		final ResponderPesquisaDisplay display = getResponderPesquisaDisplay();
		display.getLista().addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				int linhaSelecionada = display.getLinhaSelecionada(event);
				if (linhaSelecionada > 0) {
					List<FuncionarioSelecionavel> avaliados = pesquisa
							.getAvaliados();
					Funcionario funcionario = avaliados
							.get(linhaSelecionada - 1);
					eventBus.fireEvent(new EventoResponderPesquisaFuncionario(
							funcionario, pesquisa));
				}
			}
		});
	}

}
