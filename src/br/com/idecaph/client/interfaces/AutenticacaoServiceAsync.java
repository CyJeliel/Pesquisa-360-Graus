package br.com.idecaph.client.interfaces;

import br.com.idecaph.shared.FuncionarioClient;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AutenticacaoServiceAsync {

	void isLogado(AsyncCallback<Boolean> asyncCallback);

	void login(String login, String senha, AsyncCallback<FuncionarioClient> asyncCallback);

	void logout(AsyncCallback<Void> asyncCallback);
}
