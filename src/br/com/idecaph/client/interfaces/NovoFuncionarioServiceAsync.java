package br.com.idecaph.client.interfaces;

import br.com.idecaph.shared.Funcionario;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface NovoFuncionarioServiceAsync {

	void cadastraFuncionario(Funcionario funcionario,
			AsyncCallback<Boolean> callback);

	void atualizaFuncionario(Funcionario funcionario,
			AsyncCallback<Boolean> asyncCallback);

}
