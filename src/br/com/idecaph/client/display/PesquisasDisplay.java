package br.com.idecaph.client.display;

import br.com.idecaph.shared.PesquisaClient;

import com.google.gwt.event.dom.client.ClickHandler;

public interface PesquisasDisplay extends Display {

	public static final int TITULO_PESQUISA = 0;
	public static final int PERGUNTA_PESQUISA = 1;
	public static final int ERRO_CADASTRO = 2;
	public static final int SUCESSO_CADASTRO = 3;

	void getAcaoSalvar(ClickHandler clickHandler);

	PesquisaClient getDadosNovaPesquisa();

	void exibeErro(int nomeFuncionario);

}
