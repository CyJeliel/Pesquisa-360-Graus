package br.com.idecaph.client.view.novaPesquisa;

import br.com.idecaph.client.display.HasFeedbackDisplay;
import br.com.idecaph.client.display.NovaPesquisaDisplay;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.CellPanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class NovaPesquisaView extends Composite implements NovaPesquisaDisplay,
		HasFeedbackDisplay {
	@UiField
	CellPanel body;
	@UiField
	TextBox titulo;
	@UiField
	Image proximaPagina;
	private static NovaPesquisaViewUiBinder uiBinder = GWT
			.create(NovaPesquisaViewUiBinder.class);

	interface NovaPesquisaViewUiBinder extends
			UiBinder<Widget, NovaPesquisaView> {
	}

	public NovaPesquisaView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public CellPanel asWidget() {
		return body;
	}

	@Override
	public HasClickHandlers getAcaoProximaEtapa() {
		return proximaPagina;
	}

	@Override
	public String getTituloPesquisa() {
		return titulo.getText();
	}

	@Override
	public void exibeErro(int tituloInvalido) {
		String mensagem = null;
		switch (tituloInvalido) {
		case TITULO_INVALIDO:
			mensagem = "O título não pode estar em branco.";
			break;
		default:
			break;
		}
		if (mensagem != null) {
			Window.alert(mensagem);
		}
	}

	@Override
	public void exibeFeedback(int tipoFeedback) {
		// TODO Auto-generated method stub

	}

}
