package br.com.idecaph.client.presenter;

import java.util.ArrayList;
import java.util.List;

import br.com.idecaph.client.display.PerguntasPesquisaDisplay;
import br.com.idecaph.client.interfaces.PesquisaService;
import br.com.idecaph.client.interfaces.PesquisaServiceAsync;
import br.com.idecaph.client.utils.SelectionModel;
import br.com.idecaph.client.view.colunas.PerguntaColunas;
import br.com.idecaph.shared.PerguntaClient;
import br.com.idecaph.shared.PesquisaClient;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class PerguntasPesquisaPresenter extends
		Presenter<PerguntasPesquisaDisplay> {
	private PesquisaClient pesquisa;
	private List<PerguntaClient> perguntas;
	private SelectionModel<PerguntaClient> selectionModel;
	private static final int COLUNA_SELECIONAR = 0;
	protected static final int COLUNA_EDITAR = 2;
	protected static final int COLUNA_EXCLUIR = 3;

	private PesquisaServiceAsync rpcService = GWT.create(PesquisaService.class);

	public PerguntasPesquisaPresenter(PerguntasPesquisaDisplay display,
			HandlerManager eventBus, PesquisaClient pesquisa) {
		super(display, eventBus);
		this.pesquisa = pesquisa;
	}

	@Override
	public void bind() {
		final PerguntasPesquisaDisplay display = super.getDisplay();
		PerguntaColunas perguntaColunas = new PerguntaColunas();
		display.setColunas(perguntaColunas.getDefinicoesColunas());
		perguntas = pesquisa.getPerguntas();
		atualizaTabela();
		selectionModel = new SelectionModel<PerguntaClient>(perguntas);
		boolean todosSelecionados = true;
		if (perguntas != null && !perguntas.isEmpty()) {
			for (PerguntaClient pergunta : perguntas) {
				if (pergunta.isSelecionada()) {
					selectionModel.addSelection(pergunta);
				} else {
					todosSelecionados = false;
				}
			}
			if (todosSelecionados) {
				display.setCheckBoxTituloSelecionado();
			}
			display.marcarSelecionados(perguntas);
		}

		display.getAcaoProximaEtapa().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (selectionModel.isEmpty() || selectionModel.size() < 1) {
					Window.alert("Selecione uma ou mais perguntas para participar da pesquisa");
				} else {
					List<PerguntaClient> perguntasSelecionadas = new ArrayList<PerguntaClient>();
					for (PerguntaClient pergunta : selectionModel.getSelectedItems()) {
						if (selectionModel.isSelected(pergunta)) {
							pergunta.seleciona();
						}
						perguntasSelecionadas.add(pergunta);
					}
					pesquisa.setPerguntas(perguntasSelecionadas);
					cadastraPesquisa(pesquisa);
				}
			}
		});

		display.getLista().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				int linhaSelecionada = display.getLinhaSelecionada(event);
				int colunaSelecionada = display.getColunaSelecionada(event);
				if (linhaSelecionada > 0) {
					PerguntaClient pergunta = perguntas.get(linhaSelecionada - 1);
					if (colunaSelecionada == COLUNA_SELECIONAR) {
						if (selectionModel.isSelected(pergunta)) {
							selectionModel.removeSelection(pergunta);
						} else {
							selectionModel.addSelection(pergunta);
						}
					} else if (colunaSelecionada == COLUNA_EDITAR) {
						editaPergunta(pergunta, linhaSelecionada,
								colunaSelecionada);
					} else if (colunaSelecionada == COLUNA_EXCLUIR) {
						excluiPergunta(pergunta);
					}
				}
			}
		});

		display.getAcaoSelecionarTodos().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				selecionarTudo();
			}
		});

		display.getAcaoNovaPergunta().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				HasText hasText = display.getTextNovaPergunta();
				String pergunta = hasText.getText();
				if (validaPergunta(pergunta)) {
					PerguntaClient novaPergunta = new PerguntaClient(null, pergunta);
					addPergunta(novaPergunta);
//					selectionModel.addSelection(novaPergunta);
					atualizaTabela();
				}
				hasText.setText("");
			}
		});
	}

	private void cadastraPesquisa(PesquisaClient pesquisa) {
		final PerguntasPesquisaDisplay display = super.getDisplay();
		rpcService.cadastraPesquisa(pesquisa, new AsyncCallback<Boolean>() {
			@Override
			public void onSuccess(Boolean sucesso) {
				if (sucesso) {
					display.exibeFeedback(PerguntasPesquisaDisplay.PESQUISA_CADASTRADA);
				} else {
					display.exibeFeedback(PerguntasPesquisaDisplay.ERRO_CADASTRO_PESQUISA);
				}
			}

			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
				display.exibeFeedback(PerguntasPesquisaDisplay.PESQUISA_CADASTRADA);
			}
		});
	}

	private void excluiPergunta(PerguntaClient pergunta) {
		perguntas.remove(pergunta);
		selectionModel.removeSelection(pergunta);
		atualizaTabela();
	}

	private void editaPergunta(PerguntaClient pergunta, int linhaSelecionada,
			int colunaSelecionada) {
		String perguntaParaEditar = pergunta.getDisplayPergunta();
		PerguntasPesquisaDisplay display = super.getDisplay();
		display.getTextNovaPergunta().setText(perguntaParaEditar);
	}

	private void addPergunta(PerguntaClient novaPergunta) {
		if (perguntas == null) {
			perguntas = new ArrayList<PerguntaClient>();
		}
		perguntas.add(novaPergunta);
		selectionModel.addSelection(novaPergunta);
	}

	private void atualizaTabela() {
		PerguntaClient titulo = new PerguntaClient(null, "<b>PERGUNTAS</b>");
		Widget listaVazia = new PerguntaColunas().getColunaListaVazia();
		PerguntasPesquisaDisplay display = super.getDisplay();
		display.atualizaTabela(perguntas, titulo, listaVazia);
	}

	private void exibeErro(String tipoErro) {
		PerguntasPesquisaDisplay display = super.getDisplay();
		display.exibeErro(tipoErro);
	}

	private void selecionarTudo() {
		if (perguntas != null) {
			final PerguntasPesquisaDisplay display = super.getDisplay();
			CheckBox acaoSelecionarTodos = (CheckBox) display
					.getAcaoSelecionarTodos();
			boolean isSelecionado = acaoSelecionarTodos.getValue();
			boolean selecao = true;
			if (isSelecionado) {
				selectionModel.addTodos(perguntas);
			} else {
				selectionModel.removeTodos();
				selecao = false;
			}
			display.setSelecao(selecao);
		}
	}

	private boolean validaPergunta(String pergunta) {
		boolean retorno = true;
		if (pergunta == null || pergunta.isEmpty()) {
			retorno = false;
			exibeErro(PerguntasPesquisaDisplay.PERGUNTA_INVALIDA);
		} else if (perguntas != null
				&& perguntas.contains(new PerguntaClient(null, pergunta))) {
			retorno = false;
			exibeErro(PerguntasPesquisaDisplay.PERGUNTA_EXISTENTE);
		}
		return retorno;
	}

}
