package br.com.idecaph.dao;

import java.util.List;

import javax.jdo.Query;

import br.com.idecaph.model.Funcionario;
import br.com.idecaph.model.Pergunta;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class PerguntaDAO extends GenericDAO<Pergunta> {
	@Override
	public void update(Pergunta pergunta) {
		try {
			pm = PMF.get().getPersistenceManager();
			Key key = KeyFactory.createKey(Funcionario.class.getSimpleName(),
					pergunta.getId());
			Pergunta perguntaModel = pm.getObjectById(Pergunta.class, key);
			perguntaModel.setPergunta(pergunta.getPergunta());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pm.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Pergunta> getPerguntasPorPesquisa(Long idPesquisa) {
		List<Pergunta> perguntas = null;
		try {
			init();
			Query query = pm.newQuery(Pergunta.class);
			query.setFilter("idPesquisa == idPesquisaParam");
			query.declareParameters("Long idPesquisaParam");
			query.setOrdering("posicao asc");
			perguntas = (List<Pergunta>) query.execute(idPesquisa);
			perguntas.size();
			query.closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			end();
		}
		return perguntas;
	}

	public Integer qtdPerguntas(Long idPesquisa) {
		List<Pergunta> perguntasPorPesquisa = getPerguntasPorPesquisa(idPesquisa);
		return perguntasPorPesquisa == null ? 0 : perguntasPorPesquisa.size();
	}
}
