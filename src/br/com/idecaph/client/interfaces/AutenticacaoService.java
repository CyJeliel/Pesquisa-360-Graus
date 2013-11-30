package br.com.idecaph.client.interfaces;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("autenticacao")
public interface AutenticacaoService extends RemoteService {

	boolean isLogado();

	boolean login(String login, String senha);

	void logout();
}
