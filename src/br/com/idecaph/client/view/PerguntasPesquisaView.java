package br.com.idecaph.client.view;

import java.util.List;

import br.com.idecaph.client.display.PerguntasPesquisaDisplay;
import br.com.idecaph.shared.PerguntaClient;

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

public class PerguntasPesquisaView extends TableView<PerguntaClient>
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

	public void marcarSelecionados(List<PerguntaClient> todos) {
		for (int i = 0; i < todos.size(); ++i) {
			PerguntaClient pergunta = todos.get(i);
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

	@Override
	public void exibeFeedback(int tipoFeedback) {
		exibeErro(tipoFeedback);
	}

	public void exibeErro(int tipoErro) {
		String mensagemErro = "";
		switch (tipoErro) {
		case PESQUISA_CADASTRADA:
			mensagemErro = "Pesquisa cadastrada com sucesso.";
			break;
		case ERRO_CADASTRO_PESQUISA:
			mensagemErro = "Erro ao cadastrar a pesquisa Por favor, contate o administrador do sistema.";
			break;
		default:
			break;
		}
		exibeFeedback(mensagemErro);
	}

	private void exibeFeedback(String feedback) {
		Window.alert(feedback);
	}
	
}
