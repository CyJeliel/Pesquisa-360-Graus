package br.com.idecaph.client.view;

import br.com.idecaph.client.display.ExibirRelatorioDisplay;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class ExibirRelatorioView extends Composite implements ExibirRelatorioDisplay{

	@UiField
	Label nomeFuncionario;
	@UiField
	VerticalPanel body;
	
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
	public VerticalPanel getPainelResultados() {
		return body;
	}

	@Override
	public void addResultado(VerticalPanel resultado) {
		body.add(resultado);
	}

	@Override
	public VerticalPanel getNovoPainelResultado() {
		return new VerticalPanel();
	}

	@Override
	public void add(String label, VerticalPanel resultado, String style) {
		Label child = new Label(label);
		child.addStyleName(style);
		resultado.add(child);
	}

	@Override
	public void setMensagemRelatorioVazio() {
		body.add(new Label("Ainda não há resultados dessa pesquisa para esse avaliado."));
	}
	
}
