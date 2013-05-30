package br.com.idecaph.server;

import java.util.List;

import br.com.idecaph.client.interfaces.PesquisaService;
import br.com.idecaph.mock.PesquisaMock;
import br.com.idecaph.shared.Pesquisa;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class PesquisasServiceImpl extends RemoteServiceServlet implements PesquisaService{
	private static final long serialVersionUID = 1L;

	@Override
	public boolean cadastraPesquisa(Pesquisa pesquisa) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Pesquisa> getPesquisasExistentes() {
		List<Pesquisa> pesquisas = PesquisaMock.getAll();
		return pesquisas;
	}

	@Override
	public Pesquisa getPesquisa() {
		Pesquisa pesquisa = PesquisaMock.getPesquisa();
		return pesquisa;
	}

}
