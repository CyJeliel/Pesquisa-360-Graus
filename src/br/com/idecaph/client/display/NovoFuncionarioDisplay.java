package br.com.idecaph.client.display;

import br.com.idecaph.shared.FuncionarioClient;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.TextBox;

public interface NovoFuncionarioDisplay extends Display {

	public static final int NOME_FUNCIONARIO = 0;

	public static final int IDENTIFICACAO_FUNCIONARIO = 1;

	public static final int CARGO_FUNCIONARIO = 2;

	public static final int DEPARTAMENTO_FUNCIONARIO = 3;

	public static final int CADASTRO_FUNCIONARIO = 4;

	public static final int ERRO_CADASTRO_FUNCIONARIO = 5;

	public static final int ATUALIZA_FUNCIONARIO = 6;

	public static final int ERRO_ATUALIZA_FUNCIONARIO = 7;

	public static final int LOGIN_FUNCIONARIO = 8;

	public static final int SENHA_FUNCIONARIO = 9;

	public static final int CONFIRMACAO_SENHA_FUNCIONARIO = 10;

	public static final int SENHA_NAO_CONFERE_FUNCIONARIO = 11;

	FuncionarioClient getDadosNovoFuncionario();

	HasClickHandlers getAcaoSalvar();

	HasClickHandlers getAcaoCancelar();

	void exibeErro(int nomeFuncionario);

	void exibeFeedback(int tipoFeedback);

	HasText getNome();

	TextBox getIdentificacao();

	HasText getCargo();

	HasText getDepartamento();

	TextBox getId();

	HasText getLogin();

	HasText getSenha();

	HasText getConfirmacaoSenha();

	HasValue<Boolean> getAdmin();

}
