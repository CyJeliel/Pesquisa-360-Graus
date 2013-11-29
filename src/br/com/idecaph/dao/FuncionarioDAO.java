package br.com.idecaph.dao;

import br.com.idecaph.model.Funcionario;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class FuncionarioDAO extends GenericDAO<Funcionario> {

	@Override
	public void update(Funcionario funcionario) {
		try {
			pm = PMF.get().getPersistenceManager();
			Key key = KeyFactory.createKey(Funcionario.class.getSimpleName(),
					funcionario.getId());
			Funcionario funcionarioModel = pm.getObjectById(Funcionario.class,
					key);
			funcionarioModel.setNome(funcionario.getNome());
			funcionarioModel.setCargo(funcionario.getCargo());
			funcionarioModel.setDepartamento(funcionario.getDepartamento());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pm.close();
		}
	}

	public Funcionario getByEmail(String email) {
		// TODO Alterar para pegar participante atual
		return new Funcionario(5l, null, null, null, null);
	}
}
