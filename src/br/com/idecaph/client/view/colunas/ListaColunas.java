package br.com.idecaph.client.view.colunas;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

public abstract class ListaColunas {
	private Widget colunaVazia;

	public ListaColunas(String mensagemListaVazia) {
		this.colunaVazia = new HTML(mensagemListaVazia);
	}
	
	public Widget getColunaListaVazia() {
		return colunaVazia;
	}
}
