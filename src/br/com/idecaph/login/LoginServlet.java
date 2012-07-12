package br.com.idecaph.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PAGINA_INICIAL = "/Index";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		UserService userService = UserServiceFactory.getUserService();
		String url;
		if (request.getUserPrincipal() != null) {
			url = PAGINA_INICIAL;
			setDominio(request);
		} else {
			url = userService.createLoginURL(PAGINA_INICIAL);
		}
		try {
			response.sendRedirect(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setDominio(HttpServletRequest request) {
		Dominio dominio = new Dominio();
		dominio.setDominio(request);
	}

}
