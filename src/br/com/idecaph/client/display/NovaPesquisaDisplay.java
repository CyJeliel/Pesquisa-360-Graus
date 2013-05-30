package br.com.idecaph.client.display;

import com.google.gwt.event.dom.client.HasClickHandlers;

public interface NovaPesquisaDisplay extends Display {
	public static final int TITULO_INVALIDO = 0;

	HasClickHandlers getAcaoProximaEtapa();

	String getTituloPesquisa();

	void exibeErro(int tituloInvalido);

}
