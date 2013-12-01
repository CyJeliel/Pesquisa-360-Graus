package br.com.idecaph.client.presenter;

import java.util.ArrayList;
import java.util.List;

import br.com.idecaph.client.display.RelatoriosDisplay;
import br.com.idecaph.client.eventos.EventoExibirRelatorio;
import br.com.idecaph.client.interfaces.PesquisaService;
import br.com.idecaph.client.interfaces.PesquisaServiceAsync;
import br.com.idecaph.client.interfaces.RelatorioService;
import br.com.idecaph.client.interfaces.RelatorioServiceAsync;
import br.com.idecaph.client.view.colunas.AvaliadoColunas;
import br.com.idecaph.shared.FuncionarioClient;
import br.com.idecaph.shared.FuncionarioSelecionavel;
import br.com.idecaph.shared.PesquisaClient;
import br.com.idecaph.shared.RelatorioClient;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;

public class RelatoriosPresenter extends Presenter<RelatoriosDisplay> {
	private PesquisaServiceAsync rpcService = GWT.create(PesquisaService.class);
	private List<PesquisaClient> pesquisas;
	private List<FuncionarioSelecionavel> avaliados;
	private PesquisaClient pesquisaAtual;
	private RelatorioServiceAsync rpcServiceRelatorio = GWT
			.create(RelatorioService.class);

	public RelatoriosPresenter(RelatoriosDisplay display,
			HandlerManager eventBus) {
		super(display, eventBus);
	}

	@Override
	public void bind() {
		final RelatoriosDisplay display = getRelatoriosDisplay();
		rpcService
				.getPesquisasExistentes(new AsyncCallback<List<PesquisaClient>>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						Window.alert("onFailure " + caught);

					}

					@Override
					public void onSuccess(List<PesquisaClient> result) {
						pesquisas = result;
						List<String> pesquisasExistentes = new ArrayList<String>();
						if (result != null && !result.isEmpty()) {
							for (PesquisaClient pesquisa : result) {
								String titulo = pesquisa.getDisplayTitulo();
								pesquisasExistentes.add(titulo);
							}
						} else {
							Window.alert("Não há pesquisas cadastradas no sistema.");
						}
						display.setPesquisasExistentes(pesquisasExistentes);
					}
				});

		display.getAcaoExibirRelatorio().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String tituloEscolhido = display.getBoxTituloPesquisa()
						.getText();
				for (PesquisaClient pesquisa : pesquisas) {
					String tituloCandidado = pesquisa.getDisplayTitulo();
					if (tituloCandidado.equals(tituloEscolhido)) {
						avaliados = pesquisa.getAvaliados();
						pesquisaAtual = pesquisa;
						atualizaTabela();
						break;
					}
				}
			}
		});

		display.getLista().addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				int linhaSelecionada = display.getLinhaSelecionada(event);
				if (linhaSelecionada > 0) {
					FuncionarioClient funcionario = avaliados.get(
							linhaSelecionada - 1).getFuncionario();
					carregarRelatorioGeral(funcionario, pesquisaAtual.getId());
				}
			}
		});
	}

	private void carregarRelatorioGeral(final FuncionarioClient avaliado,
			Long idPesquisa) {
		rpcServiceRelatorio.getRelatorioGeral(idPesquisa, avaliado.getId(),
				new AsyncCallback<List<RelatorioClient>>() {
					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
					}

					@Override
					public void onSuccess(List<RelatorioClient> result) {
						eventBus.fireEvent(new EventoExibirRelatorio(avaliado,
								result));
					}
				});

	}

	private void atualizaTabela() {
		final RelatoriosDisplay display = getRelatoriosDisplay();
		AvaliadoColunas colunas = new AvaliadoColunas();
		display.setColunas(colunas.getColunas());
		FuncionarioSelecionavel titulo = new FuncionarioSelecionavel(null,
				"<b>FUNCIONÁRIOS AVALIADOS</b>", "<b>IDENTIFICAÇÃO</b>",
				"<b>CARGO</b>", "<b>DEPARTAMENTO</b>", false);
		Widget listaVazia = new AvaliadoColunas().getColunaListaVazia();
		List<FuncionarioSelecionavel> funcionariosSelecionaveis = new ArrayList<FuncionarioSelecionavel>();
		for (FuncionarioSelecionavel funcionario : avaliados) {
			funcionariosSelecionaveis.add(funcionario);
		}
		display.atualizaTabela(funcionariosSelecionaveis, titulo, listaVazia);
	}

	private RelatoriosDisplay getRelatoriosDisplay() {
		return super.getDisplay();
	}

}
