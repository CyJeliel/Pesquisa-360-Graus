package br.com.idecaph.client.view.colunas;

import java.util.List;

import br.com.idecaph.shared.FuncionarioSelecionavel;

public class AvaliadoColunas extends FuncionarioColunas {
	public AvaliadoColunas() {
		super("Não há funcionários avaliados nessa pesquisa.");
	}

	public List<Coluna<FuncionarioSelecionavel>> getColunas() {
		return getDefinicoesColunas();
	}
	
	protected void add(Coluna<FuncionarioSelecionavel> coluna){
		super.add(coluna);
	}

}
