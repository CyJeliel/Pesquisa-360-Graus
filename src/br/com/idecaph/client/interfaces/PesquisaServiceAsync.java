package br.com.idecaph.client.interfaces;

import java.util.List;

import br.com.idecaph.shared.PesquisaClient;
import br.com.idecaph.shared.RespostaClient;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PesquisaServiceAsync {

	void cadastraPesquisa(PesquisaClient pesquisa,
			AsyncCallback<Boolean> asyncCallback);

	void getPesquisasExistentes(
			AsyncCallback<List<PesquisaClient>> asyncCallback);

	void getPesquisaAtual(AsyncCallback<PesquisaClient> asyncCallback);

	void salvarResposta(RespostaClient respostaClient,
			AsyncCallback<Boolean> callback);

	void getPosicaoUltimaPerguntaRespondida(Long idPesquisa, Long idAvaliado,
			AsyncCallback<Integer> callback);

	void getPesquisasPorParticipante(AsyncCallback<List<PesquisaClient>> callback);

	void getPesquisaPorId(Long id, AsyncCallback<PesquisaClient> asyncCallback);

}
