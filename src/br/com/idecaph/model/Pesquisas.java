package br.com.idecaph.model;

import java.util.List;

import javax.jdo.Query;

import br.com.idecaph.shared.Pesquisa;

public class Pesquisas extends Model<Pesquisas, Pesquisa> {

	public static List<Pesquisas> getAll() {
		Query query = pm.newQuery(Pesquisas.class);
		@SuppressWarnings("unchecked")
		List<Pesquisas> pesquisas = (List<Pesquisas>) query.execute();
		return pesquisas;
	}

	@Override
	public boolean update(Pesquisa t) {
		// TODO Auto-generated method stub
		return false;
	}
}
