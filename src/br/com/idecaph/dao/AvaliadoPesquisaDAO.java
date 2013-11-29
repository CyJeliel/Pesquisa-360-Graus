package br.com.idecaph.dao;

import java.util.List;

import javax.jdo.Query;

import br.com.idecaph.model.AvaliadoPesquisa;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class AvaliadoPesquisaDAO extends GenericDAO<AvaliadoPesquisa> {

	@Override
	public void update(AvaliadoPesquisa avaliadoPesquisa) {
		try {
			pm = PMF.get().getPersistenceManager();
			Key key = KeyFactory.createKey(
					AvaliadoPesquisa.class.getSimpleName(),
					avaliadoPesquisa.getId());
			AvaliadoPesquisa avaliadoModel = pm.getObjectById(
					AvaliadoPesquisa.class, key);
			avaliadoModel.setIdFuncionario(avaliadoPesquisa.getIdFuncionario());
			avaliadoModel.setIdPesquisa(avaliadoPesquisa.getIdPesquisa());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pm.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<AvaliadoPesquisa> buscarAvaliados(Long idPesquisa) {
		List<AvaliadoPesquisa> avaliados = null;
		try {
			init();
			Query query = pm.newQuery(AvaliadoPesquisa.class);
			query.setFilter("idPesquisa == idPesquisaParam");
			query.declareParameters("Long idPesquisaParam");
			avaliados = (List<AvaliadoPesquisa>) query.execute(idPesquisa);
			avaliados.size();
			query.closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			end();
		}
		return avaliados;
	}
}
