package br.com.idecaph.dao;

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
}
