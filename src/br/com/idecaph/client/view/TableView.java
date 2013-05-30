package br.com.idecaph.client.view;

import java.util.List;

import br.com.idecaph.client.view.colunas.Coluna;
import br.com.idecaph.client.view.colunas.InformacaoTabela;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLTable.Cell;
import com.google.gwt.user.client.ui.HTMLTable.RowFormatter;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @author cindy
 *
 * @param <T> objeto exibido na tabela
 */
public abstract class TableView<T extends InformacaoTabela> extends
		Composite {
	private FlexTable table;
	private List<Coluna<T>> colunas;

	protected void setTable(FlexTable table) {
		this.table = table;
	}

	public void atualizaTabela(List<T> lista, T titulo, Widget listaVazia) {
		table.removeAllRows();
		RowFormatter linha = table.getRowFormatter();
		int maximo = colunas.size();
		if (this instanceof FuncionariosView){
			maximo -= 2;
		}
		for (int j = 0; j < maximo; ++j) {
			Coluna<T> coluna = colunas.get(j);
			table.setWidget(0, j, coluna.render(titulo));
		}
		table.setWidget(0, colunas.size(), new Label());
		linha.addStyleName(0, "tituloLista");

		if (lista == null || lista.isEmpty()) {
			table.setWidget(1, 1, listaVazia);
		} else {
			int qtdItens = lista.size();
			for (int i = 0; i < qtdItens; ++i) {
				T item = lista.get(i);
				for (int j = 0; j < colunas.size(); ++j) {
					Coluna<T> coluna = colunas.get(j);
					table.setWidget(i + 1, j, coluna.render(item));
				}
			}
			for (int i = 1; i <= qtdItens; ++i) {
				if (i % 2 == 0) {
					linha.addStyleName(i, "linhaParLista");
				}
			}
		}
	}

	public void setColunas(List<Coluna<T>> colunas) {
		this.colunas = colunas;
	}

	public int getLinhaSelecionada(ClickEvent event) {
		Cell itemClicado = table.getCellForEvent(event);
		int linhaSelecionada = itemClicado.getRowIndex();
		return linhaSelecionada;
	}

	public int getColunaSelecionada(ClickEvent event) {
		Cell itemClicado = table.getCellForEvent(event);
		int colunaSelecionada = itemClicado.getCellIndex();
		return colunaSelecionada;
	}

	public HasClickHandlers getLista() {
		return table;
	}

	public void setSelecao(boolean selecao) {
		for (int i = 1; i < table.getRowCount(); ++i) {
			CheckBox checkBox = (CheckBox) table.getWidget(i, 0);
			checkBox.setValue(selecao);
		}
	}

	public HasClickHandlers getAcaoSelecionarTodos() {
		return (HasClickHandlers) table.getWidget(0, 0);
	}
	
	protected void addEstilo(String styleName) {
		table.addStyleName(styleName);
	}

}
