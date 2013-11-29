package br.com.idecaph.client.view;

import java.util.List;

import br.com.idecaph.client.display.FuncionariosDisplay;
import br.com.idecaph.client.display.HasFeedbackDisplay;
import br.com.idecaph.client.view.colunas.Coluna;
import br.com.idecaph.shared.FuncionarioSelecionavel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CellPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

public class FuncionariosView extends TableView<FuncionarioSelecionavel>
		implements FuncionariosDisplay, HasFeedbackDisplay {
	@UiField
	CellPanel body;
	@UiField
	FlexTable tabelaFuncionarios;
	@UiField
	Image novoFuncionario;
	@UiField
	Button novaPesquisa;

	private static FuncionariosViewUiBinder uiBinder = GWT
			.create(FuncionariosViewUiBinder.class);

	interface FuncionariosViewUiBinder extends
			UiBinder<Widget, FuncionariosView> {
	}

	public FuncionariosView() {
		initWidget(uiBinder.createAndBindUi(this));
		super.setTable(tabelaFuncionarios);
	}

	@Override
	public CellPanel asWidget() {
		return body;
	}

	@Override
	public void exibeErro(int tipoErro) {
		String mensagemErro = "";
		switch (tipoErro) {
		case LISTA_FUNCIONARIOS:
			mensagemErro = "Erro ao buscar os funcionários.";
			break;
		case EXCLUIR_FUNCIONARIO:
			mensagemErro = "Funcionário excluído com sucesso.";
			break;
		case ERRO_EXCLUIR_FUNCIONARIO:
			mensagemErro = "Erro ao excluir o funcionário.";
			break;
		default:
			break;
		}
		exibeFeedback(mensagemErro);
	}

	private void exibeFeedback(String feedback) {
		Window.alert(feedback);
	}

	@Override
	public HasClickHandlers getAcaoNovoFuncionario() {
		return novoFuncionario;
	}

	@Override
	public void exibeFeedback(int tipoFeedback) {
		exibeErro(tipoFeedback);
	}

	@Override
	public HasClickHandlers getAcaoNovaPesquisa() {
		return novaPesquisa;
	}

	@Override
	public void setColunas(List<Coluna<FuncionarioSelecionavel>> colunas) {
		super.setColunas(colunas);
	}

}
