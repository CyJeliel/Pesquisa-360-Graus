package br.com.idecaph.client.display;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasText;

public interface ResponderPesquisaFuncionarioDisplay extends Display{

	HasText getNomeFuncionario();

	HasText getLabelPergunta();
	
	HasClickHandlers getActionNextPage();

	String getResposta();

}
