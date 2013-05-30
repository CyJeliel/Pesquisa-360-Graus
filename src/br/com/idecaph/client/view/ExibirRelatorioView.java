package br.com.idecaph.client.view;

import br.com.idecaph.client.display.ExibirRelatorioDisplay;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class ExibirRelatorioView extends Composite implements ExibirRelatorioDisplay{

	@UiField
	Label nomeFuncionario;
//	@UiField
	Label pergunta;
	
	private static ExibirRelatorioViewUiBinder uiBinder = GWT
			.create(ExibirRelatorioViewUiBinder.class);

	interface ExibirRelatorioViewUiBinder extends
			UiBinder<Widget, ExibirRelatorioView> {
	}

	public ExibirRelatorioView() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public HasText getNomeFuncionario(){
		return nomeFuncionario;
	}
	
	@Override
	public HasText getLabelPergunta(){
		return pergunta;
	}

}
