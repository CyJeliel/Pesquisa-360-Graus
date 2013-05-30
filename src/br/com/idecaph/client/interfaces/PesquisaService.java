package br.com.idecaph.client.interfaces;

import java.util.List;

import br.com.idecaph.shared.Pesquisa;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("pesquisa")
public interface PesquisaService extends RemoteService{

	boolean cadastraPesquisa(Pesquisa pesquisa);

	List<Pesquisa> getPesquisasExistentes();

	Pesquisa getPesquisa();

}
