package br.com.idecaph.client.presenter;

import java.util.ArrayList;
import java.util.List;

import br.com.idecaph.client.display.ParticipantesPesquisaDisplay;
import br.com.idecaph.client.eventos.EventoPaginaAvaliados;
import br.com.idecaph.client.utils.SelectionModel;
import br.com.idecaph.client.view.colunas.FuncionarioEditavelColunas;
import br.com.idecaph.client.view.colunas.FuncionarioSelecionavelColunas;
import br.com.idecaph.shared.FuncionarioSelecionavel;
import br.com.idecaph.shared.Pesquisa;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Widget;

public class ParticipantesPesquisaPresenter extends
		Presenter<ParticipantesPesquisaDisplay> {
	private Pesquisa pesquisa;
	private List<FuncionarioSelecionavel> funcionarios;
	private SelectionModel<FuncionarioSelecionavel> selectionModel;
	private static final int COLUNA_SELECIONAR = 0;

	public ParticipantesPesquisaPresenter(ParticipantesPesquisaDisplay display,
			HandlerManager eventBus, Pesquisa pesquisa) {
		super(display, eventBus);
		this.pesquisa = pesquisa;
	}

	@Override
	public void bind() {
		final ParticipantesPesquisaDisplay display = super.getDisplay();
		FuncionarioSelecionavelColunas funcionarioColunas = new FuncionarioSelecionavelColunas();
		display.setColunas(funcionarioColunas.getDefinicoesColunas());
		funcionarios = pesquisa.getParticipantes();
		FuncionarioSelecionavel titulo = new FuncionarioSelecionavel(
				"<b>FUNCIONÁRIOS</b>", "<b>IDENTIFICAÇÃO</b>", "<b>CARGO</b>",
				"<b>DEPARTAMENTO</b>", false);
		Widget listaVazia = new FuncionarioEditavelColunas()
				.getColunaListaVazia();
		display.atualizaTabela(funcionarios, titulo, listaVazia);
		selectionModel = new SelectionModel<FuncionarioSelecionavel>(
				funcionarios);
		boolean todosSelecionados = true;
		if (funcionarios != null && !funcionarios.isEmpty()) {
			for (FuncionarioSelecionavel funcionario : funcionarios) {
				if (funcionario.isSelecionado()) {
					selectionModel.addSelection(funcionario);
				} else {
					todosSelecionados = false;
				}
			}
			if (todosSelecionados) {
				display.setCheckBoxTituloSelecionado();
			}
			display.marcarSelecionados(funcionarios);
		}

		display.getAcaoProximaEtapa().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (selectionModel.isEmpty() || selectionModel.size() < 2) {
					Window.alert("Selecione dois ou mais funcionários para participar da pesquisa");
				} else {
					List<FuncionarioSelecionavel> funcionariosSelecionados = new ArrayList<FuncionarioSelecionavel>();
					for (FuncionarioSelecionavel funcionario : selectionModel
							.todosItens()) {
						FuncionarioSelecionavel funcionarioSelecionado = new FuncionarioSelecionavel(
								funcionario);
						if (selectionModel.isSelected(funcionario)) {
							funcionarioSelecionado.seleciona();
						}
						funcionariosSelecionados.add(funcionarioSelecionado);
					}
					pesquisa.setParticipantes(funcionariosSelecionados);
					eventBus.fireEvent(new EventoPaginaAvaliados(pesquisa));
				}
			}
		});

		display.getLista().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				int linhaSelecionada = display.getLinhaSelecionada(event);
				int colunaSelecionada = display.getColunaSelecionada(event);
				if (linhaSelecionada > 0) {
					FuncionarioSelecionavel funcionario = funcionarios
							.get(linhaSelecionada - 1);
					if (colunaSelecionada == COLUNA_SELECIONAR) {
						itemSelecionado(funcionario);
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

	}

	private void itemSelecionado(FuncionarioSelecionavel funcionario) {
		if (selectionModel.isSelected(funcionario)) {
			selectionModel.removeSelection(funcionario);
		} else {
			selectionModel.addSelection(funcionario);
		}
	}

	private void selecionarTudo() {
		final ParticipantesPesquisaDisplay display = super.getDisplay();
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

}
