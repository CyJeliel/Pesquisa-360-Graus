package br.com.idecaph.client.view.colunas;

import java.util.List;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

import br.com.idecaph.shared.FuncionarioSelecionavel;

public class AvaliadoPorcentagemColunas extends AvaliadoColunas{
	public AvaliadoPorcentagemColunas() {
		super();
		super.add(new Coluna<FuncionarioSelecionavel>() {
			
			@Override
			public Widget render(FuncionarioSelecionavel dado) {
				return new HTML(dado.getPorcentagemRespondida());
			}
		});
	}

	public List<Coluna<FuncionarioSelecionavel>> getColunas() {
		return getDefinicoesColunas();
	}

}
