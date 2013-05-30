package br.com.idecaph.model.batch;

import java.util.List;

import javax.jdo.Query;

import br.com.idecaph.model.Funcionarios;
import br.com.idecaph.model.Pesquisas;

public class PesquisaBatch extends Batch<Pesquisas>{
	public List<Pesquisas> getAll() {
		Query query = pm.newQuery(Funcionarios.class);
		@SuppressWarnings("unchecked")
		List<Pesquisas> pesquisas = (List<Pesquisas>) query.execute();
		return pesquisas;
	}
}
