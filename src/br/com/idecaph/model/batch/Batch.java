package br.com.idecaph.model.batch;

import java.util.List;

import javax.jdo.PersistenceManager;

import br.com.idecaph.dao.PMF;

public abstract class Batch<T> {
	PersistenceManager pm = PMF.get().getPersistenceManager();

	public boolean saveAll(List<T> list) {
		boolean retorno = true;
		try {
			pm.makePersistentAll(list);
		} catch (Exception e) {
			retorno = false;
		} finally {
			pm.close();
		}
		return retorno;
	}

	public abstract List<T> getAll();
}
