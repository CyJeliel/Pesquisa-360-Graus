package br.com.idecaph.client.interfaces;

import java.util.List;

import br.com.idecaph.shared.FuncionarioClient;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface FuncionariosServiceAsync {
	void getFuncionarios(AsyncCallback<List<FuncionarioClient>> asyncCallback);

	void excluiFuncionario(Long id, AsyncCallback<Boolean> asyncCallback);

	void cadastraFuncionario(FuncionarioClient funcionario,
			AsyncCallback<Boolean> callback);

	void atualizaFuncionario(FuncionarioClient funcionario,
			AsyncCallback<Boolean> asyncCallback);

	void getFuncionarioById(FuncionarioClient funcionario,
			AsyncCallback<FuncionarioClient> asyncCallback);

}
