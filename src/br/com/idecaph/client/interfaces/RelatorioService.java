package br.com.idecaph.client.interfaces;

import java.util.List;

import br.com.idecaph.shared.RelatorioClient;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("relatorio")
public interface RelatorioService extends RemoteService{
	public List<RelatorioClient> getRelatorioGeral(Long idPesquisa, Long idAvaliado);
}
