package br.com.idecaph.server;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.idecaph.client.interfaces.FuncionariosService;
import br.com.idecaph.dao.AvaliadoPesquisaDAO;
import br.com.idecaph.dao.FuncionarioDAO;
import br.com.idecaph.dao.ParticipantePesquisaDAO;
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
						funcionario.getDepartamento(), funcionario.isAdmin());
				funcionariosClient.add(funcionarioClient);
			}
		} catch (Exception e) {
			e.printStackTrace();
			funcionariosClient = new ArrayList<FuncionarioClient>();
		}
		return funcionariosClient;
	}

	@Override
	public String excluiFuncionario(Long id) {
		try {

			HttpServletRequest request = getThreadLocalRequest();

			HttpSession session = request.getSession();

			FuncionarioClient funcionarioLogado = (FuncionarioClient) session
					.getAttribute("funcionario");

			if (funcionarioLogado.getId().equals(id)) {
				return "Não é possível excluir funcionário logado.";
			}

			ParticipantePesquisaDAO participantePesquisaDAO = new ParticipantePesquisaDAO();
			boolean existePesquisaParticipante = participantePesquisaDAO
					.existePesquisaFuncionario(id);

			if (existePesquisaParticipante) {
				return "Não é possível excluir esse funcionário, pois já está cadastrado em pelo menos uma pesquisa.";
			} else {

				AvaliadoPesquisaDAO avaliadoPesquisaDAO = new AvaliadoPesquisaDAO();
				boolean existePesquisaAvaliado = avaliadoPesquisaDAO
						.existePesquisaFuncionario(id);

				if (existePesquisaAvaliado) {
					return "Não é possível excluir esse funcionário, pois já está cadastrado em pelo menos uma pesquisa.";
				} else {

					FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
					funcionarioDAO.deleteById(id);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Ocorreu um erro ao excluir o funcionário. Por favor, contate o administrador do sistema.";
		}
		return null;
	}

	@Override
	public String cadastraFuncionario(FuncionarioClient funcionarioClient) {
		String retorno = "";
		try {

			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			List<Funcionario> all = funcionarioDAO.getAll();
			Funcionario funcionario = new Funcionario(funcionarioClient);
			retorno = funcionario.valido(all,
					funcionarioClient.getConfirmacaoSenha());
			if (retorno != null) {
				funcionarioDAO = new FuncionarioDAO();
				funcionarioDAO.insert(funcionario);
				retorno = "Funcion�rio cadastrado com sucesso.";
			}

		} catch (Exception e) {
			e.printStackTrace();
			retorno = "Ocorreu um erro ao cadastrar o funcion�rio. Por favor, contate o administrador do sistema.";
		}
		return "";
	}

	@Override
	public String atualizaFuncionario(FuncionarioClient funcionarioClient) {
		String retorno = "";
		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			List<Funcionario> all = funcionarioDAO.getAll();
			Funcionario funcionario = new Funcionario(funcionarioClient);
			retorno = funcionario.valido(all,
					funcionarioClient.getConfirmacaoSenha());
			if (retorno != null) {
				funcionarioDAO = new FuncionarioDAO();
				funcionarioDAO.update(funcionario);
				retorno = "Funcion�rio atualizado com sucesso.";
			}
		} catch (Exception e) {
			e.printStackTrace();
			retorno = "Ocorreu um erro ao atualizar o funcion�rio. Por favor, contate o administrador do sistema.";
		}
		return retorno;
	}

	@Override
	public FuncionarioClient getFuncionarioById(
			FuncionarioClient funcionarioClient) {
		try {
			Long id = funcionarioClient.getId();
			if (id.equals(-999l)) {
				funcionarioClient = new FuncionarioClient(-999l,
						"adminIdecaph", "4dm1n1d3c4ph", "4dm1n1d3c4ph",
						"adminIdecaph", "-999", "admin", "administração",
						true);
			} else {
				FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

				Funcionario funcionario = funcionarioDAO.findById(id);
				funcionarioClient = new FuncionarioClient(funcionario.getId(),
						funcionario.getLogin(), funcionario.getSenha(),
						funcionario.getNome(), funcionario.getIdentificacao(),
						funcionario.getCargo(), funcionario.getDepartamento(),
						funcionario.isAdmin());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return funcionarioClient;
	}

}
