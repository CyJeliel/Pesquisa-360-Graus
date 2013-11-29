package br.com.idecaph.client.interfaces;

import java.util.List;

import br.com.idecaph.shared.PesquisaClient;
import br.com.idecaph.shared.RespostaClient;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("pesquisa")
public interface PesquisaService extends RemoteService {

	boolean cadastraPesquisa(PesquisaClient pesquisa);

	List<PesquisaClient> getPesquisasExistentes();

	PesquisaClient getPesquisaAtual();

	Boolean salvarResposta(RespostaClient respostaClient);

	long getIdUltimaPerguntaRespondida(Long idPesquisa, Long idAvaliado);

}
