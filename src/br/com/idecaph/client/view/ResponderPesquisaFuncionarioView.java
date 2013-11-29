package br.com.idecaph.client.view;

import java.util.ArrayList;
import java.util.List;

import br.com.idecaph.client.display.ResponderPesquisaFuncionarioDisplay;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Image;
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
	@UiField
	Image proximaPagina;
	
	List<RadioButton> respostas;

	private static ResponderPesquisaFuncionarioViewUiBinder uiBinder = GWT
			.create(ResponderPesquisaFuncionarioViewUiBinder.class);

	interface ResponderPesquisaFuncionarioViewUiBinder extends
			UiBinder<Widget, ResponderPesquisaFuncionarioView> {
	}

	public ResponderPesquisaFuncionarioView() {
		initWidget(uiBinder.createAndBindUi(this));
		respostas = new ArrayList<RadioButton>();
		respostas.add(resposta1);
		respostas.add(resposta2);
		respostas.add(resposta3);
		respostas.add(resposta4);
		respostas.add(resposta5);
	}

	@Override
	public HasText getNomeFuncionario() {
		return nomeFuncionario;
	}

	@Override
	public HasText getLabelPergunta() {
		return pergunta;
	}

	@Override
	public HasClickHandlers getActionNextPage() {
		return proximaPagina;
	}
	
	@Override
	public String getResposta(){
		String retorno = "";
		for (RadioButton resposta: respostas){
			if (resposta.getValue()){
				retorno =  resposta.getText();
			}
		}
		return retorno;
	}

}
