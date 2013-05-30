package br.com.idecaph.client.presenter;

import java.util.ArrayList;
import java.util.List;

import br.com.idecaph.client.display.PerguntasPesquisaDisplay;
import br.com.idecaph.client.eventos.EventoPaginaAvaliados;
import br.com.idecaph.client.utils.SelectionModel;
import br.com.idecaph.client.view.colunas.PerguntaColunas;
import br.com.idecaph.shared.Pergunta;
import br.com.idecaph.shared.Pesquisa;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class PerguntasPesquisaPresenter extends
		Presenter<PerguntasPesquisaDisplay> {
	private Pesquisa pesquisa;
	private List<Pergunta> perguntas;
	private SelectionModel<Pergunta> selectionModel;
	private static final int COLUNA_SELECIONAR = 0;
	protected static final int COLUNA_EDITAR = 2;
	protected static final int COLUNA_EXCLUIR = 3;

	public PerguntasPesquisaPresenter(PerguntasPesquisaDisplay display,
			HandlerManager eventBus, Pesquisa pesquisa) {
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
		selectionModel = new SelectionModel<Pergunta>(perguntas);
		boolean todosSelecionados = true;
		if (perguntas != null && !perguntas.isEmpty()) {
			for (Pergunta pergunta : perguntas) {
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
					List<Pergunta> perguntasSelecionadas = new ArrayList<Pergunta>();
					for (Pergunta pergunta : selectionModel.todosItens()) {
						if (selectionModel.isSelected(pergunta)) {
							pergunta.seleciona();
						}
						perguntasSelecionadas.add(pergunta);
					}
					pesquisa.setPerguntas(perguntasSelecionadas);
					eventBus.fireEvent(new EventoPaginaAvaliados(pesquisa));
				}
			}
		});

		display.getLista().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				int linhaSelecionada = display.getLinhaSelecionada(event);
				int colunaSelecionada = display.getColunaSelecionada(event);
				if (linhaSelecionada > 0) {
					Pergunta pergunta = perguntas.get(linhaSelecionada - 1);
					if (colunaSelecionada == COLUNA_SELECIONAR) {
						itemSelecionado(pergunta);
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
					Pergunta novaPergunta = new Pergunta(pergunta, null);
					addPergunta(novaPergunta);
					selectionModel.addSelection(novaPergunta);
					atualizaTabela();
				}
				hasText.setText("");
			}
		});
	}

	private void excluiPergunta(Pergunta pergunta) {
		perguntas.remove(pergunta);
		selectionModel.removeSelection(pergunta);
		atualizaTabela();
	}

	private void editaPergunta(Pergunta pergunta, int linhaSelecionada,
			int colunaSelecionada) {
		String perguntaParaEditar = pergunta.getDisplayPergunta();
		PerguntasPesquisaDisplay display = super.getDisplay();
		display.getTextNovaPergunta().setText(perguntaParaEditar);
	}

	private void addPergunta(Pergunta novaPergunta) {
		if (perguntas == null) {
			perguntas = new ArrayList<Pergunta>();
		}
		perguntas.add(novaPergunta);
	}

	private void atualizaTabela() {
		Pergunta titulo = new Pergunta("<b>PERGUNTAS</b>", null);
		Widget listaVazia = new PerguntaColunas().getColunaListaVazia();
		PerguntasPesquisaDisplay display = super.getDisplay();
		display.atualizaTabela(perguntas, titulo, listaVazia);
	}

	private void exibeErro(String tipoErro) {
		PerguntasPesquisaDisplay display = super.getDisplay();
		display.exibeErro(tipoErro);
	}

	private void itemSelecionado(Pergunta pergunta) {
		if (selectionModel.isSelected(pergunta)) {
			selectionModel.removeSelection(pergunta);
		} else {
			selectionModel.addSelection(pergunta);
		}
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
				&& perguntas.contains(new Pergunta(pergunta, null))) {
			retorno = false;
			exibeErro(PerguntasPesquisaDisplay.PERGUNTA_EXISTENTE);
		}
		return retorno;
	}

}
