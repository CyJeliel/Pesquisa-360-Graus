package br.com.idecaph.dao;

import java.util.List;

import javax.jdo.Query;

import br.com.idecaph.model.Pesquisa;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class PesquisaDAO extends GenericDAO<Pesquisa> {
	private Pesquisa pesquisa;

	public void setNome(String nome) {
		this.pesquisa = new Pesquisa();
		this.pesquisa.setNome(nome);
	}

	public String getNome() {
		return this.pesquisa.getNome();
	}

	public Pesquisa getPesquisa() {
		return pesquisa;
	}

	@Override
	public void update(Pesquisa pesquisa) {
		try {
			pm = PMF.get().getPersistenceManager();
			Key key = KeyFactory.createKey(Pesquisa.class.getSimpleName(),
					pesquisa.getId());
			Pesquisa pesquisaModel = pm.getObjectById(Pesquisa.class, key);
			pesquisaModel.setNome(pesquisa.getNome());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pm.close();
		}

	}

	@SuppressWarnings("unchecked")
	public Pesquisa getPesquisaAtual() {
		List<Pesquisa> pesquisas = null;
		try {
			init();
			Query query = pm.newQuery(Pesquisa.class);
			query.setOrdering("id desc");
			pesquisas = (List<Pesquisa>) query.execute();
			pesquisas.size();
			query.closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			end();
		}
		return pesquisas == null || pesquisas.isEmpty() ? new Pesquisa()
				: pesquisas.get(0);
	}
}
