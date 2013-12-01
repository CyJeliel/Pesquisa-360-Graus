package br.com.idecaph.client.presenter;

import java.util.List;

import br.com.idecaph.client.display.ResponderPesquisaDisplay;
import br.com.idecaph.client.eventos.EventoResponderPesquisaFuncionario;
import br.com.idecaph.client.interfaces.PesquisaService;
import br.com.idecaph.client.interfaces.PesquisaServiceAsync;
import br.com.idecaph.client.view.colunas.AvaliadoPorcentagemColunas;
import br.com.idecaph.shared.FuncionarioClient;
import br.com.idecaph.shared.FuncionarioSelecionavel;
import br.com.idecaph.shared.PesquisaClient;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;

public class ResponderPesquisaPresenter extends
		Presenter<ResponderPesquisaDisplay> {
	private PesquisaServiceAsync rpcService = GWT.create(PesquisaService.class);
	private PesquisaClient pesquisa;

	public ResponderPesquisaPresenter(ResponderPesquisaDisplay display,
			HandlerManager eventBus) {
		super(display, eventBus);
	}

	@Override
	public void bind() {

		rpcService.getPesquisaAtual(new AsyncCallback<PesquisaClient>() {

			@Override
			public void onSuccess(PesquisaClient result) {
				pesquisa = result;
				
				if (result!= null){
					atualizaTitulo();
					atualizaTabela();
					atualizaTotalRespondido();
					addHandlers();
				} else {
					Window.alert("Não há pesquisas cadastradas no sistema.");
				}
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}
		});
	}

	private void atualizaTotalRespondido() {
		final ResponderPesquisaDisplay display = getResponderPesquisaDisplay();
		display.getTotalRespondido().setText("Total Respondido: " + pesquisa.getPorcentagemPesquisaRespondida() + "%");
	}

	private void atualizaTitulo() {
		final ResponderPesquisaDisplay display = getResponderPesquisaDisplay();
		display.getTituloPesquisa().setText(pesquisa.getDisplayTitulo());
	}

	private void atualizaTabela() {
		final ResponderPesquisaDisplay display = getResponderPesquisaDisplay();
		AvaliadoPorcentagemColunas colunas = new AvaliadoPorcentagemColunas();
		display.setColunas(colunas.getColunas());
		FuncionarioSelecionavel titulo = new FuncionarioSelecionavel(null,
				"<b>FUNCIONÃ�RIOS AVALIADOS</b>", "<b>IDENTIFICAÃ‡ÃƒO</b>",
				"<b>CARGO</b>", "<b>DEPARTAMENTO</b>", false);
		Widget listaVazia = new AvaliadoPorcentagemColunas()
				.getColunaListaVazia();
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
					FuncionarioClient funcionario = avaliados.get(
							linhaSelecionada - 1).getFuncionario();
					carregarUltimaPerguntaRespondida(funcionario);
				}
			}
		});
	}

	private void carregarUltimaPerguntaRespondida(final FuncionarioClient funcionario) {
		rpcService.getPosicaoUltimaPerguntaRespondida(pesquisa.getId(), funcionario.getId(), new AsyncCallback<Integer>() {

			@Override
			public void onFailure(Throwable caught) {
			}

			@Override
			public void onSuccess(Integer result) {
				if (result == null || result < 0){
					Window.alert("Não há mais perguntas a responder para esse avaliado.");
				} else {
					pesquisa.setPosicaoUltimaPerguntaRespondida(result);
					eventBus.fireEvent(new EventoResponderPesquisaFuncionario(
							funcionario, pesquisa));
				}
			}
		});
	}

}
