package br.com.idecaph.client.display;

import java.util.List;

import br.com.idecaph.client.view.colunas.Coluna;
import br.com.idecaph.client.view.colunas.InformacaoTabela;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

public interface TableDisplay<T extends InformacaoTabela> extends Display {

	HasClickHandlers getAcaoSelecionarTodos();

	void setColunas(List<Coluna<T>> colunas);

	public void atualizaTabela(List<T> lista, T titulo, Widget listaVazia);

	HasClickHandlers getLista();

	int getLinhaSelecionada(ClickEvent event);

	int getColunaSelecionada(ClickEvent event);

	void setSelecao(boolean selecao);
}
