package br.com.idecaph.client.view;

import br.com.idecaph.client.display.ResponderPesquisaFuncionarioDisplay;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.i18n.server.testing.Gender;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Widget;

public class ResponderPesquisaFuncionarioView extends Composite implements
		ResponderPesquisaFuncionarioDisplay {

	@UiField
	Label nomeFuncionario;
	@UiField
	Label pergunta;
	@UiField
	RadioButton resposta1;
	@UiField
	RadioButton resposta2;
	@UiField
	RadioButton resposta3;
	@UiField
	RadioButton resposta4;
	@UiField
	RadioButton resposta5;

	private static ResponderPesquisaFuncionarioViewUiBinder uiBinder = GWT
			.create(ResponderPesquisaFuncionarioViewUiBinder.class);

	interface ResponderPesquisaFuncionarioViewUiBinder extends
			UiBinder<Widget, ResponderPesquisaFuncionarioView> {
	}

	@UiHandler({ "resposta1", "resposta2", "resposta3", "resposta4",
			"resposta5" })
	void onChangeGender(ValueChangeEvent<Boolean> e) {
		//TODO Fazer a troca de clicks
		if (resposta1.getValue()){
			resposta2.setValue(false);
			resposta3.setValue(false);
			resposta4.setValue(false);
			resposta5.setValue(false);
		} else if (resposta2.getValue()){
			resposta1.setValue(false);
			resposta3.setValue(false);
			resposta4.setValue(false);
			resposta5.setValue(false);
		} else if (resposta3.getValue()){
			resposta1.setValue(false);
			resposta2.setValue(false);
			resposta4.setValue(false);
			resposta5.setValue(false);
		} else if (resposta4.getValue()){
			resposta1.setValue(false);
			resposta2.setValue(false);
			resposta3.setValue(false);
			resposta5.setValue(false);
		} else if (resposta5.getValue()){
			resposta1.setValue(false);
			resposta2.setValue(false);
			resposta3.setValue(false);
			resposta4.setValue(false);
		}
	}

	public ResponderPesquisaFuncionarioView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public HasText getNomeFuncionario() {
		return nomeFuncionario;
	}

	@Override
	public HasText getLabelPergunta() {
		return pergunta;
	}

}
