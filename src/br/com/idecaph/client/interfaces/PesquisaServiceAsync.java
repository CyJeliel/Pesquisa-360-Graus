package br.com.idecaph.client.interfaces;

import java.util.List;

import br.com.idecaph.shared.Pesquisa;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PesquisaServiceAsync {

	void cadastraPesquisa(Pesquisa pesquisa,
			AsyncCallback<Boolean> asyncCallback);

	void getPesquisasExistentes(AsyncCallback<List<Pesquisa>> asyncCallback);

	void getPesquisa(AsyncCallback<Pesquisa> asyncCallback);

}
