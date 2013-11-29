package br.com.idecaph.dao;

import java.util.List;

import javax.jdo.Query;

import br.com.idecaph.model.Resposta;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class RespostaDAO extends GenericDAO<Resposta> {

	@Override
	public void update(Resposta resposta) {
		try {
			pm = PMF.get().getPersistenceManager();
			Key key = KeyFactory.createKey(Resposta.class.getSimpleName(),
					resposta.getId());
			Resposta respostaModel = pm.getObjectById(Resposta.class, key);
			respostaModel.setDescricao(resposta.getDescricao());
			respostaModel.setIdAvaliado(resposta.getIdAvaliado());
			respostaModel.setIdParticipante(resposta.getIdParticipante());
			respostaModel.setIdPergunta(resposta.getIdPergunta());
			respostaModel.setIdPesquisa(resposta.getIdPesquisa());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pm.close();
		}
	}

	@SuppressWarnings("unchecked")
	public Integer qtdRespostasParticipantePorAvaliado(Long idPesquisa,
			Long idParticipante, Long idAvaliado) {
		List<Resposta> respostas = null;
		String filter = "idPesquisa == idPesquisaParam && idParticipante == idParticipanteParam && idAvaliado == idAvaliadoParam";
		try {
			init();
			Query query = pm.newQuery(Resposta.class, filter);
			query.declareParameters("Long idPesquisaParam, Long idParticipanteParam, Long idAvaliadoParam");
			respostas = (List<Resposta>) query.execute(idPesquisa,
					idParticipante, idAvaliado);
			respostas.size();
			query.closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			end();
		}
		return respostas == null ? 0 : respostas.size();
	}

	@SuppressWarnings("unchecked")
	public List<Resposta> getRespostasAvaliado(Long idPesquisa, Long idAvaliado) {
		List<Resposta> respostas = null;
		String filter = "idPesquisa == idPesquisaParam && idAvaliado == idAvaliadoParam";
		try {
			init();
			Query query = pm.newQuery(Resposta.class, filter);
			query.declareParameters("Long idPesquisaParam, Long idAvaliadoParam");
			query.setOrdering("idPergunta asc");
			respostas = (List<Resposta>) query.execute(idPesquisa, idAvaliado);
			respostas.size();
			query.closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			end();
		}
		return respostas;
	}

	@SuppressWarnings("unchecked")
	public Long getUltimaPerguntaRespondida(Long idPesquisa,
			Long idParticipante, Long idAvaliado) {
		String filter = "idPesquisa == idPesquisaParam && idParticipante == idParticipanteParam && idAvaliado == idAvaliadoParam";
		List<Resposta> respostas = null;
		Long retorno = 0l;
		try {
			init();
			Query query = pm.newQuery(Resposta.class, filter);
			query.declareParameters("Long idPesquisaParam, Long idParticipanteParam, Long idAvaliadoParam");
			query.setOrdering("idPergunta desc");
			respostas = (List<Resposta>) query.execute(idPesquisa,
					idParticipante, idAvaliado);
			if (respostas != null && !respostas.isEmpty()){
				retorno = respostas.get(0).getIdPergunta();
			}
		} catch (Exception e) {
			retorno  = 0l;
			e.printStackTrace();
		} finally {
			end();
		}
		if (retorno == null){
			retorno = 0l;
		}
		return retorno;
	}
}
