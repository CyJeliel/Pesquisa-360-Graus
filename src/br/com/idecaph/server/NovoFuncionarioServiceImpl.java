package br.com.idecaph.server;

import br.com.idecaph.client.interfaces.NovoFuncionarioService;
import br.com.idecaph.model.Funcionarios;
import br.com.idecaph.shared.Funcionario;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class NovoFuncionarioServiceImpl extends RemoteServiceServlet implements NovoFuncionarioService{
	private static final long serialVersionUID = 1L;

	@Override
	public Boolean cadastraFuncionario(Funcionario funcionario) {
		Funcionarios funcionarioModel = new Funcionarios(
				funcionario.getIdentificacao(), funcionario.getCargo(),
				funcionario.getNome(), funcionario.getDepartamento());
		boolean ok = funcionarioModel.save();
		return ok;
	}

	@Override
	public boolean atualizaFuncionario(Funcionario funcionario) {
		Funcionarios funcionarioModel = new Funcionarios(
				funcionario.getIdentificacao(), funcionario.getCargo(),
				funcionario.getNome(), funcionario.getDepartamento());
		boolean ok = funcionarioModel.update(funcionario);
		return ok;
	}

}
