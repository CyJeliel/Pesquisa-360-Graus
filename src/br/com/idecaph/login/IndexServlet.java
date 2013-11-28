package br.com.idecaph.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class IndexServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		UserService userService = UserServiceFactory.getUserService();
		User usuario = userService.getCurrentUser();
		String email = usuario.getEmail();
		String domain = email.substring(email.indexOf("@") + 1);
		HttpSession session = request.getSession();
		session.setAttribute("domain", domain);
		
		GerenciadorAutenticacao gerenciadorAutenticacao = new GerenciadorAutenticacao();
		gerenciadorAutenticacao.setParametrosContaUsuario(session);
		try {
			response.sendRedirect("/index.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
