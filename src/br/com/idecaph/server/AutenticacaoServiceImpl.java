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
	public boolean login(String login, String senha) {
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

		try {
			
			Funcionario funcionario = funcionarioDAO.findByLoginSenha(login, senha);
			
			HttpServletRequest request = getThreadLocalRequest();

			HttpSession session = request.getSession();
			
			FuncionarioClient funcionarioClient = new FuncionarioClient(funcionario.getId(), funcionario.getLogin(), funcionario.getSenha(), funcionario.getNome(), funcionario.getIdentificacao(), funcionario.getCargo(), funcionario.getDepartamento());
			
			session.setAttribute("funcionario", funcionarioClient);
			
			return true;

		} catch (Exception e){
			
			return false;
		}
		
	}

	@Override
	public void logout() {

		HttpServletRequest request = getThreadLocalRequest();

		HttpSession session = request.getSession();
		
		session.setAttribute("funcionario", null);
	}

}
