package br.com.idecaph.client.view.colunas;

import com.google.gwt.user.client.ui.Widget;

public abstract class Coluna<T extends InformacaoTabela> {
	public abstract Widget render(T dado);

    public boolean isClickable() {
      return false;
    }

    public boolean isSelectable() {
      return false;
    }

	public void setIsSelecionado(boolean selecionado) {
	}
  }