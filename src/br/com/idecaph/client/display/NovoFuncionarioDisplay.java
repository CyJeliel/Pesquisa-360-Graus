package br.com.idecaph.client.display;

import br.com.idecaph.shared.Funcionario;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.TextBox;

public interface NovoFuncionarioDisplay extends Display {

	public static final int NOME_FUNCIONARIO = 0;

	public static final int IDENTIFICACAO_FUNCIONARIO = 1;

	public static final int CARGO_FUNCIONARIO = 2;

	public static final int DEPARTAMENTO_FUNCIONARIO = 3;

	public static final int CADASTRO_FUNCIONARIO = 4;

	public static final int ERRO_CADASTRO_FUNCIONARIO = 5;

	public static final int ATUALIZA_FUNCIONARIO = 6;

	public static final int EXCLUIR_FUNCIONARIO = 7;

	public static final int ERRO_EXCLUIR_FUNCIONARIO = 8;

	public static final int ERRO_ATUALIZA_FUNCIONARIO = 9;

	Funcionario getDadosNovoFuncionario();

	HasClickHandlers getAcaoSalvar();

	HasClickHandlers getAcaoCancelar();

	void exibeErro(int nomeFuncionario);

	void exibeFeedback(int tipoFeedback);

	HasText getNome();

	TextBox getIdentificacao();

	HasText getCargo();

	HasText getDepartamento();

}
