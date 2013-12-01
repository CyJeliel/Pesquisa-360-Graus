package br.com.idecaph.dao;

import java.util.List;

import javax.jdo.Query;

import br.com.idecaph.model.Pergunta;
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
	public List<Resposta> getRespostasAvaliado(Long idPesquisa, Long idAvaliado, Long idParticipante) {
		List<Resposta> respostas = null;
		String filter = "idPesquisa == idPesquisaParam && idParticipante == idParticipanteParam && idAvaliado == idAvaliadoParam";
		try {
			init();
			Query query = pm.newQuery(Resposta.class, filter);
			query.declareParameters("Long idPesquisaParam, Long idParticipanteParam, Long idAvaliadoParam");
			query.setOrdering("idPergunta asc");
			respostas = (List<Resposta>) query.execute(idPesquisa, idParticipante, idAvaliado);
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
	public Integer getUltimaPerguntaRespondida(Long idPesquisa,
			Long idParticipante, Long idAvaliado) {
		String filter = "idPesquisa == idPesquisaParam && idParticipante == idParticipanteParam && idAvaliado == idAvaliadoParam";
		List<Resposta> respostas = null;
		Integer retorno = 0;
		try {
			init();
			Query query = pm.newQuery(Resposta.class, filter);
			query.declareParameters("Long idPesquisaParam, Long idParticipanteParam, Long idAvaliadoParam");
			respostas = (List<Resposta>) query.execute(idPesquisa,
					idParticipante, idAvaliado);
			Integer posicao = Integer.MIN_VALUE;
			if (respostas != null && !respostas.isEmpty()){
				for (Resposta resposta: respostas){
					Long idPergunta = resposta.getIdPergunta();
					PerguntaDAO perguntaDAO = new PerguntaDAO();
					Pergunta pergunta = perguntaDAO.findById(idPergunta);
					if(pergunta != null && pergunta.getPosicao() != null && pergunta.getPosicao() >= posicao){ 
						posicao = pergunta.getPosicao();
					}
				}
				retorno = posicao;
			}
		} catch (Exception e) {
			retorno  = 0;
			e.printStackTrace();
		} finally {
			end();
		}
		if (retorno == null){
			retorno = 0;
		}
		return retorno;
	}

	@SuppressWarnings("unchecked")
	public List<Resposta> getTodasRespostasAvaliado(Long idPesquisa,
			Long idAvaliado) {
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
}
