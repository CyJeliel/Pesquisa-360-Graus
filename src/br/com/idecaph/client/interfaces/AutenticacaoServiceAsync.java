package br.com.idecaph.client.interfaces;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AutenticacaoServiceAsync {

	void isLogado(AsyncCallback<Boolean> asyncCallback);

	void login(String login, String senha, AsyncCallback<Boolean> asyncCallback);

	void logout(AsyncCallback<Void> asyncCallback);
}
