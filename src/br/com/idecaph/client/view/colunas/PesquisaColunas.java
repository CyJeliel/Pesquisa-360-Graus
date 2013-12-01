package br.com.idecaph.client.view.colunas;

import java.util.ArrayList;
import java.util.List;

import br.com.idecaph.shared.PesquisaClient;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

public class PesquisaColunas extends ListaColunas {

	private List<Coluna<PesquisaClient>> definicoesColunas = new ArrayList<Coluna<PesquisaClient>>();

	public PesquisaColunas() {
		super("Não há pesquisas cadastradas para esse usuário.");

		definicoesColunas.add(new Coluna<PesquisaClient>() {

			@Override
			public Widget render(PesquisaClient dado) {
				return new HTML(dado.getDisplayTitulo());
			}

		});
	}

	public List<Coluna<PesquisaClient>> getDefinicoesColunas() {
		return definicoesColunas;
	}

}
