package br.com.idecaph.model;

import javax.jdo.PersistenceManager;

import br.com.idecaph.dao.PMF;

public abstract class Model<T, U> {
	protected static PersistenceManager pm = PMF.get().getPersistenceManager();

	public boolean save() {
		boolean retorno = true;
		try {
			pm = getPM();
			pm.makePersistent(this);
		} catch (Exception e) {
			retorno = false;
		} finally {
			pm.close();
		}
		return retorno;
	}

	public abstract boolean update(U u);

	public boolean delete(T t) {
		boolean retorno = true;
		try {
			pm = getPM();
			pm.deletePersistent(this);
		} catch (Exception e) {
			retorno = false;
		} finally {
			pm.close();
		}
		return retorno;
	}
	
	private PersistenceManager getPM() {
		if (pm.isClosed()){
			pm = PMF.get().getPersistenceManager();
		}
		return pm;
	}
}