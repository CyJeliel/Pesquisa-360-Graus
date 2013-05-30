package br.com.idecaph.client.view;

import br.com.idecaph.client.display.NovoFuncionarioDisplay;
import br.com.idecaph.shared.Funcionario;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CellPanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class NovoFuncionarioView extends Composite implements NovoFuncionarioDisplay{
	@UiField
	CellPanel body;
	@UiField
	TextBox nome;
	@UiField
	TextBox identificacao;
	@UiField
	TextBox cargo;
	@UiField
	TextBox departamento;
	@UiField
	Button botaoSalvar;
	@UiField
	Button botaoCancelar;
	private static NovoFuncionarioViewUiBinder uiBinder = GWT
			.create(NovoFuncionarioViewUiBinder.class);

	interface NovoFuncionarioViewUiBinder extends
			UiBinder<Widget, NovoFuncionarioView> {
	}

	public NovoFuncionarioView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public Funcionario getDadosNovoFuncionario() {
		String nome = this.nome.getText();
		String identificacao = this.identificacao.getText();
		String cargo = this.cargo.getText();
		String departamento = this.departamento.getText();
		Funcionario funcionario = new Funcionario(nome, identificacao, cargo,
				departamento);
		return funcionario;
	}

	@Override
	public HasClickHandlers getAcaoSalvar() {
		return botaoSalvar;
	}

	@Override
	public HasClickHandlers getAcaoCancelar() {
		return botaoCancelar;
	}

	@Override
	public void exibeErro(int tipoErro) {
		String mensagemErro = "";
		switch (tipoErro) {
		case NOME_FUNCIONARIO:
			mensagemErro = "O nome do funcionário não pode estar em branco.";
			break;
		case IDENTIFICACAO_FUNCIONARIO:
			mensagemErro = "A identificação do funcionário não pode estar em branco.";
			break;
		case CARGO_FUNCIONARIO:
			mensagemErro = "O cargo do funcionário não pode estar em branco.";
			break;
		case DEPARTAMENTO_FUNCIONARIO:
			mensagemErro = "O departamento do funcionário não pode estar em branco.";
			break;
		case CADASTRO_FUNCIONARIO:
			mensagemErro = "Cadastrou o funcionário.";
			break;			
		case ERRO_CADASTRO_FUNCIONARIO:
			mensagemErro = "Erro ao cadastrar o funcionário.";
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
	public void exibeFeedback(int tipoFeedback) {
		exibeErro(tipoFeedback);
	}

	@Override
	public CellPanel asWidget() {
		return body;
	}

	@Override
	public HasText getNome() {
		return nome;
	}

	@Override
	public TextBox getIdentificacao() {
		return identificacao;
	}

	@Override
	public HasText getCargo() {
		return cargo;
	}

	@Override
	public HasText getDepartamento() {
		return departamento;
	}

}
