package br.com.idecaph.login;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class Dominio {
	private static final Logger log = Logger.getLogger(Dominio.class.getName());

	public void setDominio(HttpServletRequest request) {
		UserService userService = UserServiceFactory.getUserService();
		User usuario = userService.getCurrentUser();
		String email = usuario.getEmail();
		String domain = email.substring(email.indexOf("@") + 1);
		HttpSession session = request.getSession();
		log.info("Dominio = " + domain);
		session.setAttribute("domain", domain);
		GerenciadorAutenticacao gerenciadorAutenticacao = new GerenciadorAutenticacao();
		gerenciadorAutenticacao.setParametrosContaUsuario(session);
	}
}
