package br.com.idecaph.client.presenter;

import java.util.ArrayList;
import java.util.List;

import br.com.idecaph.client.display.RelatoriosDisplay;
import br.com.idecaph.client.eventos.EventoExibirRelatorio;
import br.com.idecaph.client.interfaces.PesquisaService;
import br.com.idecaph.client.interfaces.PesquisaServiceAsync;
import br.com.idecaph.client.view.colunas.AvaliadoColunas;
import br.com.idecaph.shared.Funcionario;
import br.com.idecaph.shared.FuncionarioSelecionavel;
import br.com.idecaph.shared.Pesquisa;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;

public class RelatoriosPresenter extends Presenter<RelatoriosDisplay> {
	private PesquisaServiceAsync rpcService = GWT.create(PesquisaService.class);
	private List<Pesquisa> pesquisas;
	private List<FuncionarioSelecionavel> avaliados;

	public RelatoriosPresenter(RelatoriosDisplay display,
			HandlerManager eventBus) {
		super(display, eventBus);
	}

	@Override
	public void bind() {
		final RelatoriosDisplay display = getRelatoriosDisplay();
		rpcService.getPesquisasExistentes(new AsyncCallback<List<Pesquisa>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("onFailure " + caught);

			}

			@Override
			public void onSuccess(List<Pesquisa> result) {
				pesquisas = result;
				List<String> pesquisasExistentes = new ArrayList<String>();
				for (Pesquisa pesquisa : result) {
					String titulo = pesquisa.getDisplayTitulo();
					pesquisasExistentes.add(titulo);
				}
				display.setPesquisasExistentes(pesquisasExistentes);
			}
		});

		display.getAcaoExibirRelatorio().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String tituloEscolhido = display.getBoxTituloPesquisa()
						.getText();
				for (Pesquisa pesquisa : pesquisas) {
					String tituloCandidado = pesquisa.getDisplayTitulo();
					if (tituloCandidado.equals(tituloEscolhido)) {
						avaliados = pesquisa.getAvaliados();
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
					Funcionario funcionario = avaliados
							.get(linhaSelecionada - 1);
					eventBus.fireEvent(new EventoExibirRelatorio(funcionario, pesquisas.get(linhaSelecionada-1)));
				}
			}
		});
	}

	protected void atualizaTabela() {
		final RelatoriosDisplay display = getRelatoriosDisplay();
		AvaliadoColunas colunas = new AvaliadoColunas();
		display.setColunas(colunas.getColunas());
		FuncionarioSelecionavel titulo = new FuncionarioSelecionavel(
				"<b>FUNCIONÁRIOS AVALIADOS</b>", "<b>IDENTIFICAÇÃO</b>", "<b>CARGO</b>", "<b>DEPARTAMENTO</b>", false);
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
