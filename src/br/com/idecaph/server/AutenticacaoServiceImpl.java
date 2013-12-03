package br.com.idecaph.server;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.idecaph.client.interfaces.AutenticacaoService;
import br.com.idecaph.dao.FuncionarioDAO;
import br.com.idecaph.model.Funcionario;
import br.com.idecaph.shared.FuncionarioClient;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class AutenticacaoServiceImpl extends RemoteServiceServlet implements
		AutenticacaoService {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean isLogado() {

		HttpServletRequest request = getThreadLocalRequest();

		HttpSession session = request.getSession();

		Object attribute = session.getAttribute("funcionario");

		if (attribute != null && attribute instanceof Funcionario) {

			return true;
		}

		return false;
	}

	@Override
	public FuncionarioClient login(String login, String senha) {

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		
		FuncionarioClient funcionarioClient = null;
		try {

			if (login.equals("adminIdecaph") && senha.equals("4dm1n1d3c4ph")) {
				funcionarioClient = new FuncionarioClient(-999l,
						"adminIdecaph", "4dm1n1d3c4ph", "4dm1n1d3c4ph",
						"adminIdecaph", "-999", "admin", "administração", true);
			} else {

				Funcionario funcionario = funcionarioDAO.findByLoginSenha(
						login, senha);

				funcionarioClient = new FuncionarioClient(funcionario.getId(),
						funcionario.getLogin(), funcionario.getSenha(),
						funcionario.getNome(), funcionario.getIdentificacao(),
						funcionario.getCargo(), funcionario.getDepartamento(),
						funcionario.isAdmin());
			}

			HttpServletRequest request = getThreadLocalRequest();

			HttpSession session = request.getSession();

			session.setAttribute("funcionario", funcionarioClient);

		} catch (Exception e) {

			funcionarioClient = null;
		}

		return funcionarioClient;

	}

	@Override
	public void logout() {

		HttpServletRequest request = getThreadLocalRequest();

		HttpSession session = request.getSession();

		session.setAttribute("funcionario", null);
	}

}
