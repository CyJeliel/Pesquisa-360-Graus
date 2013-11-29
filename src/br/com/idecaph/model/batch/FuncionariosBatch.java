package br.com.idecaph.model.batch;

import java.util.List;

import javax.jdo.Query;

import br.com.idecaph.model.Funcionario;

public class FuncionariosBatch extends Batch<Funcionario> {

	public List<Funcionario> getAll() {
		Query query = pm.newQuery(Funcionario.class);
		@SuppressWarnings("unchecked")
		List<Funcionario> funcionarios = (List<Funcionario>) query.execute();
		return funcionarios;
	}
}
