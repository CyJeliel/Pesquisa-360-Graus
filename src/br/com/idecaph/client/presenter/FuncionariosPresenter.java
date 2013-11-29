package br.com.idecaph.client.presenter;

import java.util.ArrayList;
import java.util.List;

import br.com.idecaph.client.display.FuncionariosDisplay;
import br.com.idecaph.client.eventos.EventoCarregaFuncionarios;
import br.com.idecaph.client.eventos.EventoEditarFuncionario;
import br.com.idecaph.client.eventos.EventoExibeFuncionarios;
import br.com.idecaph.client.eventos.EventoNovaPesquisa;
import br.com.idecaph.client.eventos.EventoNovoFuncionario;
import br.com.idecaph.client.interfaces.FuncionariosService;
import br.com.idecaph.client.interfaces.FuncionariosServiceAsync;
import br.com.idecaph.client.utils.SelectionModel;
import br.com.idecaph.client.view.colunas.FuncionarioEditavelColunas;
import br.com.idecaph.shared.FuncionarioClient;
import br.com.idecaph.shared.FuncionarioSelecionavel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Widget;

public class FuncionariosPresenter extends Presenter<FuncionariosDisplay> {
	private static final int COLUNA_EDITAR = 5;
	private static final int COLUNA_EXCLUIR = 6;
	protected static final int COLUNA_SELECIONAR = 0;

	private FuncionariosServiceAsync rpcService = GWT
			.create(FuncionariosService.class);
	private List<FuncionarioClient> funcionarios;
	private SelectionModel<FuncionarioClient> selectionModel;

	public FuncionariosPresenter(FuncionariosDisplay display,
			HandlerManager eventBus, List<FuncionarioClient> funcionarios) {
		super(display, eventBus);
		this.funcionarios = funcionarios;
	}

	@Override
	public void bind() {
		final FuncionariosDisplay display = super.getDisplay();
		display.getAcaoNovoFuncionario().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				eventBus.fireEvent(new EventoNovoFuncionario());
			}
		});

		display.getAcaoNovaPesquisa().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (selectionModel.isEmpty() || selectionModel.size() < 2) {
					Window.alert("Selecione dois ou mais funcionários para iniciar uma nova pesquisa");
				} else {
					List<FuncionarioSelecionavel> funcionariosSelecionados = new ArrayList<FuncionarioSelecionavel>();
					for (FuncionarioClient funcionario : selectionModel
							.todosItens()) {
						FuncionarioSelecionavel funcionarioSelecionado = new FuncionarioSelecionavel(
								funcionario);
						if (selectionModel.isSelected(funcionario)) {
							funcionarioSelecionado.seleciona();
						}
						funcionariosSelecionados.add(funcionarioSelecionado);
					}
					eventBus.fireEvent(new EventoNovaPesquisa(
							funcionariosSelecionados));
				}
			}
		});

		display.getLista().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				int linhaSelecionada = display.getLinhaSelecionada(event);
				int colunaSelecionada = display.getColunaSelecionada(event);
				if (linhaSelecionada > 0) {
					FuncionarioClient funcionario = funcionarios
							.get(linhaSelecionada - 1);
					if (colunaSelecionada == COLUNA_EDITAR) {
						eventBus.fireEvent(new EventoEditarFuncionario(
								funcionario));
					} else if (colunaSelecionada == COLUNA_EXCLUIR) {
						excluiFuncionario(funcionario);
					} else if (colunaSelecionada == COLUNA_SELECIONAR) {
						itemSelecionado(funcionario);
					}
				}
			}
		});

		FuncionarioEditavelColunas funcionarioColunas = new FuncionarioEditavelColunas();
		display.setColunas(funcionarioColunas.getColunas());
		FuncionarioSelecionavel titulo = new FuncionarioSelecionavel(null,
				"<b>FUNCIONÁRIOS</b>", "<b>IDENTIFICAÇÃO</b>", "<b>CARGO</b>",
				"<b>DEPARTAMENTO</b>", false);
		Widget listaVazia = new FuncionarioEditavelColunas()
				.getColunaListaVazia();
		List<FuncionarioSelecionavel> funcionariosSelecionaveis = new ArrayList<FuncionarioSelecionavel>();
		for (FuncionarioClient funcionario : funcionarios) {
			FuncionarioSelecionavel funcionarioSelecionavel = new FuncionarioSelecionavel(
					funcionario);
			funcionariosSelecionaveis.add(funcionarioSelecionavel);
		}
		display.atualizaTabela(funcionariosSelecionaveis, titulo, listaVazia);
		selectionModel = new SelectionModel<FuncionarioClient>(funcionarios);

		display.getAcaoSelecionarTodos().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				selecionarTudo();
			}
		});
	}

	private void excluiFuncionario(FuncionarioClient funcionario) {
		final FuncionariosDisplay display = super.getDisplay();
		rpcService.excluiFuncionario(funcionario.getId(),
				new AsyncCallback<Boolean>() {

					@Override
					public void onSuccess(Boolean result) {
						atualizaListaFuncionarios();
					}

					@Override
					public void onFailure(Throwable caught) {
						display.exibeFeedback(FuncionariosDisplay.ERRO_EXCLUIR_FUNCIONARIO);
					}
				});
	}

	private void atualizaListaFuncionarios() {
		rpcService.getFuncionarios(new AsyncCallback<List<FuncionarioClient>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onSuccess(List<FuncionarioClient> result) {
				eventBus.fireEvent(new EventoExibeFuncionarios(result));
			}
		});
	}

	private void itemSelecionado(FuncionarioClient funcionario) {
		if (selectionModel.isSelected(funcionario)) {
			selectionModel.removeSelection(funcionario);
		} else {
			selectionModel.addSelection(funcionario);
		}
	}

	private void selecionarTudo() {
		final FuncionariosDisplay display = super.getDisplay();
		CheckBox acaoSelecionarTodos = (CheckBox) display
				.getAcaoSelecionarTodos();
		boolean isSelecionado = acaoSelecionarTodos.getValue();
		boolean selecao = true;
		if (isSelecionado) {
			selectionModel.addTodos(funcionarios);
		} else {
			selectionModel.removeTodos();
			selecao = false;
		}
		display.setSelecao(selecao);
	}

	public List<FuncionarioClient> getFuncionarios() {
		return funcionarios;
	}
}