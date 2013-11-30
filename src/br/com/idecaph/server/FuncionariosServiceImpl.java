package br.com.idecaph.server;

import java.util.ArrayList;
import java.util.List;

import br.com.idecaph.client.interfaces.FuncionariosService;
import br.com.idecaph.dao.FuncionarioDAO;
import br.com.idecaph.model.Funcionario;
import br.com.idecaph.shared.FuncionarioClient;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class FuncionariosServiceImpl extends RemoteServiceServlet implements
		FuncionariosService {
	private static final long serialVersionUID = 1L;

	@Override
	public List<FuncionarioClient> getFuncionarios() {
		List<FuncionarioClient> funcionariosClient = new ArrayList<FuncionarioClient>();
		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			List<Funcionario> funcionarios = funcionarioDAO.getAll();
			for (Funcionario funcionario : funcionarios) {
				FuncionarioClient funcionarioClient = new FuncionarioClient(
						funcionario.getId(), funcionario.getLogin(),
						funcionario.getSenha(), funcionario.getNome(),
						funcionario.getIdentificacao(), funcionario.getCargo(),
						funcionario.getDepartamento());
				funcionariosClient.add(funcionarioClient);
			}
		} catch (Exception e) {
			e.printStackTrace();
			funcionariosClient = new ArrayList<FuncionarioClient>();
		}
		return funcionariosClient;
	}

	@Override
	public boolean excluiFuncionario(Long id) {
		boolean ok = true;
		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioDAO.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			ok = false;
		}
		return ok;
	}

	@Override
	public Boolean cadastraFuncionario(FuncionarioClient funcionarioClient) {
		boolean ok = true;
		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			Funcionario funcionario = new Funcionario(funcionarioClient);
			funcionarioDAO.insert(funcionario);
		} catch (Exception e) {
			e.printStackTrace();
			ok = false;
		}
		return ok;
	}

	@Override
	public boolean atualizaFuncionario(FuncionarioClient funcionarioClient) {
		boolean ok = true;
		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			Funcionario funcionario = new Funcionario(funcionarioClient);
			funcionarioDAO.update(funcionario);
		} catch (Exception e) {
			e.printStackTrace();
			ok = false;
		}
		return ok;
	}

	@Override
	public FuncionarioClient getFuncionarioById(
			FuncionarioClient funcionarioClient) {
		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			Funcionario funcionario = funcionarioDAO.findById(funcionarioClient
					.getId());
			funcionarioClient = new FuncionarioClient(funcionario.getId(),
					funcionario.getLogin(), funcionario.getSenha(),
					funcionario.getNome(), funcionario.getIdentificacao(),
					funcionario.getCargo(), funcionario.getDepartamento());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return funcionarioClient;
	}

}
