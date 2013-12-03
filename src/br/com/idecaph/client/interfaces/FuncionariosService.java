package br.com.idecaph.client.interfaces;

import java.util.List;

import br.com.idecaph.shared.FuncionarioClient;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("funcionarios")
public interface FuncionariosService extends RemoteService {

	List<FuncionarioClient> getFuncionarios();

	String excluiFuncionario(Long id);

	String cadastraFuncionario(FuncionarioClient funcionario);

	boolean atualizaFuncionario(FuncionarioClient funcionario);

	FuncionarioClient getFuncionarioById(FuncionarioClient funcionario);

}
