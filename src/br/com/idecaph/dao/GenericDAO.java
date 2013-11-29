package br.com.idecaph.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import br.com.idecaph.model.Entity;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public abstract class GenericDAO<T extends Entity> {
	private final Class<T> persistentClass;

	PersistenceManager pm;

	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public T insert(T t) {
		init();
		t = pm.makePersistent(t);
		end();
		return t;
	}

	protected void end() {
		pm.currentTransaction().commit();
		pm.close();
	}

	protected void init() {
		pm = PMF.get().getPersistenceManager();
		pm.currentTransaction().begin();
	}

	public void deleteById(Long id) {
		init();
		T t = findById(id);
		pm.deletePersistent(t);
		end();
	}

	public T findById(Long id) {
		init();
		Key key = KeyFactory.createKey(persistentClass.getSimpleName(), id);
		T t = pm.getObjectById(persistentClass, key);
		return t;
	}

	abstract public void update(T t);

	public List<T> getAll() {
		init();
		Query query = pm.newQuery(persistentClass);
		@SuppressWarnings("unchecked")
		List<T> all = (List<T>) query.execute();
		all.size();
		query.closeAll();
		end();
		return all;
	}

	public void insertAll(List<T> ts) {
		for (T t : ts){
			insert(t);
		}
	}

}
