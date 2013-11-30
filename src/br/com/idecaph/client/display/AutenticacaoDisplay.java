package br.com.idecaph.client.display;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasText;

public interface AutenticacaoDisplay extends Display {

	HasClickHandlers getAcaoLogin();

	HasText getTextLogin();

	HasText getTextSenha();

}
