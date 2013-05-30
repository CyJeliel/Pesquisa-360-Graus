package br.com.idecaph.client.view;

import java.util.List;

import br.com.idecaph.client.display.PerguntasPesquisaDisplay;
import br.com.idecaph.shared.Pergunta;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CellPanel;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class PerguntasPesquisaView extends TableView<Pergunta>
		implements PerguntasPesquisaDisplay {
	@UiField
	CellPanel body;
	@UiField
	FlexTable tabelaPerguntas;
	@UiField
	Button proximaPagina;
	@UiField
	Image novaPergunta;
	@UiField
	TextBox pergunta;

	private static PerguntasPesquisaViewUiBinder uiBinder = GWT
			.create(PerguntasPesquisaViewUiBinder.class);

	interface PerguntasPesquisaViewUiBinder extends
			UiBinder<Widget, PerguntasPesquisaView> {
	}

	public PerguntasPesquisaView() {
		initWidget(uiBinder.createAndBindUi(this));
		super.setTable(tabelaPerguntas);
	}

	@Override
	public Widget asWidget() {
		return body;
	}

	@Override
	public HasClickHandlers getAcaoProximaEtapa() {
		return proximaPagina;
	}

	@Override
	public void setCheckBoxTituloSelecionado() {
		CheckBox checkBox = (CheckBox) tabelaPerguntas.getWidget(0, 0);
		checkBox.setValue(true);
	}

	public void marcarSelecionados(List<Pergunta> todos) {
		for (int i = 0; i < todos.size(); ++i) {
			Pergunta pergunta = todos.get(i);
			if (pergunta.isSelecionada()) {
				CheckBox checkBox = (CheckBox) tabelaPerguntas.getWidget(i + 1,
						0);
				checkBox.setValue(true);
			}
		}
	}

	@Override
	public HasClickHandlers getAcaoNovaPergunta() {
		return novaPergunta;
	}

	@Override
	public HasText getTextNovaPergunta() {
		return pergunta;
	}

	@Override
	public void exibeErro(String tipoErro) {
		Window.alert(tipoErro);
	}
	
}
