package br.com.idecaph.client.display;

import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.VerticalPanel;

public interface ExibirRelatorioDisplay extends Display{

	HasText getNomeFuncionario();

	VerticalPanel getPainelResultados();

	void addResultado(VerticalPanel resultado);

	VerticalPanel getNovoPainelResultado();

	void add(String label, VerticalPanel resultado, String style);

	void setMensagemRelatorioVazio();

}
