package br.com.idecaph.login;

import javax.servlet.http.HttpSession;

public class GerenciadorAutenticacao {

	private static final String APPS_FEEDS_URL_BASE = "https://apps-apis.google.com/a/feeds/";

	/**
	 * Método que seta alguns parâmetros da conta do usuário.
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

//	/**
//	 * Método que busca a url de Autorizacao.
//	 * 
//	 * @param session
//	 * @return {@link String} que representa a urlAutorizacao
//	 * @author Cindy
//	 */
//	public String getUrlAutorizacao(HttpSession session) {
//		EscopoAutorizacao escopoAutorizacao = new EscopoAutorizacao(session);
//		String url = escopoAutorizacao.getUrlEscopoAutorizacao();
//		Autorizacao autorizacao = new Autorizacao();
//		String urlAutorizacao = autorizacao.getUrlAutorizacao(url, session);
//		return urlAutorizacao;
//	}
}
