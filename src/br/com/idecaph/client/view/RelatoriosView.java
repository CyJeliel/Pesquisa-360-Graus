package br.com.idecaph.client.view;

import java.util.List;

import br.com.idecaph.client.display.HasFeedbackDisplay;
import br.com.idecaph.client.display.RelatoriosDisplay;
import br.com.idecaph.shared.FuncionarioSelecionavel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.Widget;

public class RelatoriosView extends TableView<FuncionarioSelecionavel>
		implements RelatoriosDisplay, HasFeedbackDisplay {

	@UiField(provided = true)
	SuggestBox escolhePesquisa;
	@UiField
	Button exibeRelatorio;
	@UiField
	FlexTable tabelaAvaliados;

	private final MultiWordSuggestOracle mySuggestions = new MultiWordSuggestOracle();

	private static RelatoriosViewUiBinder uiBinder = GWT
			.create(RelatoriosViewUiBinder.class);

	interface RelatoriosViewUiBinder extends UiBinder<Widget, RelatoriosView> {
	}

	public RelatoriosView() {
		escolhePesquisa = new SuggestBox(mySuggestions);
		initWidget(uiBinder.createAndBindUi(this));
		super.setTable(tabelaAvaliados);
	}

	@Override
	public void setPesquisasExistentes(List<String> pesquisasExistentes) {
		for (String pesquisa : pesquisasExistentes) {
			mySuggestions.add(pesquisa);
		}
	}

	@Override
	public HasClickHandlers getAcaoExibirRelatorio() {
		return exibeRelatorio;
	}

	@Override
	public void exibeErro(int tipoErro) {
		Window.alert("Erro ao selecionar pesquisa");
	}

	@Override
	public void exibeFeedback(int tipoFeedback) {
		Window.alert("Erro ao selecionar pesquisa");
	}

	@Override
	public HasText getBoxTituloPesquisa() {
		return escolhePesquisa;
	}
	@Override
	public Widget asWidget() {
		// TODO Auto-generated method stub
		return super.asWidget();
	}
	
	@Override
	public void atualizaTabela(List<FuncionarioSelecionavel> lista,
			FuncionarioSelecionavel titulo, Widget listaVazia) {
		super.atualizaTabela(lista, titulo, listaVazia);
		super.addEstilo("lista");
	}

}
