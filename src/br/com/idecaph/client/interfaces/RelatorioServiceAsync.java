package br.com.idecaph.client.interfaces;

import java.util.List;

import br.com.idecaph.shared.RelatorioClient;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RelatorioServiceAsync {

	void getRelatorioGeral(Long idPesquisa, Long idAvaliado,
			AsyncCallback<List<RelatorioClient>> callback);

}
