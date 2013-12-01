package br.com.idecaph.dao;

import java.util.List;

import javax.jdo.Query;

import br.com.idecaph.model.ParticipantePesquisa;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class ParticipantePesquisaDAO extends GenericDAO<ParticipantePesquisa> {

	@Override
	public void update(ParticipantePesquisa participantePesquisa) {
		try {
			pm = PMF.get().getPersistenceManager();
			Key key = KeyFactory.createKey(
					ParticipantePesquisa.class.getSimpleName(),
					participantePesquisa.getId());
			ParticipantePesquisa participanteModel = pm.getObjectById(
					ParticipantePesquisa.class, key);
			participanteModel.setIdFuncionario(participantePesquisa
					.getIdFuncionario());
			participanteModel.setIdPesquisa(participantePesquisa
					.getIdPesquisa());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pm.close();
		}
	}

	public boolean existePesquisaFuncionario(Long id) {

		boolean existe = false;
		List<ParticipantePesquisa> participantes = getPesquisasFuncionario(id);

		if (participantes != null && !participantes.isEmpty()) {
			existe = true;
		}
		return existe;
	}

	@SuppressWarnings("unchecked")
	public List<ParticipantePesquisa> getPesquisasFuncionario(Long id) {
		List<ParticipantePesquisa> participantes = null;
		String filter = "idFuncionario == idFuncionarioParam";
		try {
			init();
			Query query = pm.newQuery(ParticipantePesquisa.class, filter);
			query.declareParameters("Long idFuncionarioParam");
			participantes = (List<ParticipantePesquisa>) query.execute(id);
			participantes.size();
			query.closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			end();
		}

		return participantes;
	}

	@SuppressWarnings("unchecked")
	public List<ParticipantePesquisa> getParticipantesPesquisa(Long idPesquisa) {
		List<ParticipantePesquisa> participantes = null;
		String filter = "idPesquisa == idPesquisaParam";
		try {
			init();
			Query query = pm.newQuery(ParticipantePesquisa.class, filter);
			query.declareParameters("Long idPesquisaParam");
			participantes = (List<ParticipantePesquisa>) query
					.execute(idPesquisa);
			participantes.size();
			query.closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			end();
		}

		return participantes;
	}
}
