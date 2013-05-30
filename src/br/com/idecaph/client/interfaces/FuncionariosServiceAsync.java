package br.com.idecaph.client.interfaces;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import br.com.idecaph.shared.Funcionario;

public interface FuncionariosServiceAsync {
	void getFuncionarios(AsyncCallback<List<Funcionario>> asyncCallback);

	void excluiFuncionario(Funcionario funcionario,
			AsyncCallback<Boolean> asyncCallback);
}
