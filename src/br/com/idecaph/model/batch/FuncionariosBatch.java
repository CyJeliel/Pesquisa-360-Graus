package br.com.idecaph.model.batch;

import java.util.List;

import javax.jdo.Query;

import br.com.idecaph.model.Funcionarios;

public class FuncionariosBatch extends Batch<Funcionarios> {

	public List<Funcionarios> getAll() {
		Query query = pm.newQuery(Funcionarios.class);
		@SuppressWarnings("unchecked")
		List<Funcionarios> funcionarios = (List<Funcionarios>) query.execute();
		return funcionarios;
	}
}
