package br.com.idecaph.model.batch;

import java.util.List;

import javax.jdo.Query;

import br.com.idecaph.model.Funcionario;
import br.com.idecaph.model.Pesquisa;

public class PesquisaBatch extends Batch<Pesquisa>{
	public List<Pesquisa> getAll() {
		Query query = pm.newQuery(Funcionario.class);
		@SuppressWarnings("unchecked")
		List<Pesquisa> pesquisas = (List<Pesquisa>) query.execute();
		return pesquisas;
	}
}
