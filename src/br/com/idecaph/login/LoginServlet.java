package br.com.idecaph.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private static final String PAGINA_AUTORIZACAO = "/Autorizacao";
	private static final String PAGINA_INICIAL = "/Index";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		UserService userService = UserServiceFactory.getUserService();
		String url;
		if (request.getUserPrincipal() != null) {
//			boolean autorizado = verificaAutorizacao(request);
//			if (autorizado) {
				url = PAGINA_INICIAL;
//			} else {
//				url = PAGINA_AUTORIZACAO;
//			}
			setDominio(request);
		} else {
//			url = userService.createLoginURL(PAGINA_AUTORIZACAO);
			url = userService.createLoginURL(PAGINA_INICIAL);
		}
		try {
			response.sendRedirect(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	/**
//	 * Método que verifica se o token de acesso existe e ainda é válido.
//	 * 
//	 * @param request
//	 * @return <code>true</code>, caso exista o token de acesso;
//	 *         <code>false>, caso contrário.
//	 */
//	private boolean verificaAutorizacao(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		String tokenAcesso = (String) session.getAttribute("tokenAcesso");
//		String tokenSecret = (String) session.getAttribute("tokenSecret");
//		boolean sucesso = false;
//		if (tokenAcesso != null && tokenSecret != null
//				&& !tokenAcesso.equalsIgnoreCase("")
//				&& !tokenSecret.equalsIgnoreCase("")) {
//			sucesso = true;
//		}
//		return sucesso;
//	}

	public void setDominio(HttpServletRequest request) {
		Dominio dominio = new Dominio();
		dominio.setDominio(request);
	}

}
