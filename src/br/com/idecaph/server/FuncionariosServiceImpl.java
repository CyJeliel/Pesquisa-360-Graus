package br.com.idecaph.server;

import java.util.ArrayList;
import java.util.List;

import br.com.idecaph.client.interfaces.FuncionariosService;
import br.com.idecaph.mock.FuncionariosMock;
import br.com.idecaph.model.Funcionarios;
import br.com.idecaph.model.batch.FuncionariosBatch;
import br.com.idecaph.shared.Funcionario;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class FuncionariosServiceImpl extends RemoteServiceServlet implements
		FuncionariosService {
	private static final long serialVersionUID = 1L;
	private static final boolean devel = Devel.IS_DEVEL;

	@Override
	public List<Funcionario> getFuncionarios() {
		List<Funcionarios> funcionariosModel;
		if (devel){
			funcionariosModel = FuncionariosMock.getAll();
		} else {
			funcionariosModel = (new FuncionariosBatch()).getAll();
		}
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		for (Funcionarios funcionarioModel : funcionariosModel) {
			Funcionario funcionario = new Funcionario(
					funcionarioModel.getNome(),
					funcionarioModel.getIdentificacao(),
					funcionarioModel.getCargo(),
					funcionarioModel.getDepartamento());
			funcionarios.add(funcionario);
		}
		return funcionarios;
	}

	@Override
	public boolean excluiFuncionario(Funcionario funcionario) {
		Funcionarios funcionarioModel = new Funcionarios(
				funcionario.getIdentificacao(), funcionario.getCargo(),
				funcionario.getNome(), funcionario.getDepartamento());
		boolean ok = funcionarioModel.delete(funcionarioModel);
		return ok;
	}
}
