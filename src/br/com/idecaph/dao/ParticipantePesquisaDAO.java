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
		String filter = "idFuncionario == idFuncionarioParam";
		try {
			init();
			Query query = pm.newQuery(ParticipantePesquisa.class, filter);
			query.declareParameters("Long idFuncionarioParam");
			@SuppressWarnings("unchecked")
			List<ParticipantePesquisa> participantes = (List<ParticipantePesquisa>) query
					.execute(id);

			if (participantes != null && !participantes.isEmpty()) {
				existe = true;
			}
			query.closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			end();
		}
		return existe;
	}
}
