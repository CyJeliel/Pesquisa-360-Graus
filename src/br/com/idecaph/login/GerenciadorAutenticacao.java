package br.com.idecaph.login;

import javax.servlet.http.HttpSession;

public class GerenciadorAutenticacao {

	private static final String APPS_FEEDS_URL_BASE = "https://apps-apis.google.com/a/feeds/";

	/**
	 * MŽtodo que seta alguns par‰metros da conta do usu‡rio.
	 * 
	 * @param adminEmail
	 * @param adminPassword
	 * @author Cindy
	 */
	public void setParametrosContaUsuario(HttpSession session) {
		String domain = (String) session.getAttribute("domain");
		String domainUrlBase = APPS_FEEDS_URL_BASE + domain + "/";
		session.setAttribute("domainUrlBase", domainUrlBase);
	}
}
