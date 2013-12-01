package br.com.idecaph.dao;

import java.util.List;

import javax.jdo.Query;

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
			funcionarioModel.setAdmin(funcionario.isAdmin());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pm.close();
		}
	}

	public Funcionario findByLoginSenha(String login, String senha) {

		Funcionario funcionario = null;
		String filter = "login == loginParam && senha == senhaParam";
		try {
			init();
			Query query = pm.newQuery(Funcionario.class, filter);
			query.declareParameters("String loginParam, String senhaParam");
			@SuppressWarnings("unchecked")
			List<Funcionario> funcionarios = (List<Funcionario>) query.execute(
					login, senha);

			if (funcionarios != null && !funcionarios.isEmpty()) {
				funcionario = funcionarios.get(0);
			}
			query.closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			end();
		}
		return funcionario;
	}
}
