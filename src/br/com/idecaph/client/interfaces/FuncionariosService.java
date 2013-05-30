package br.com.idecaph.client.interfaces;

import java.util.List;

import br.com.idecaph.shared.Funcionario;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("funcionarios")
public interface FuncionariosService extends RemoteService {

	List<Funcionario> getFuncionarios();

	boolean excluiFuncionario(Funcionario funcionario);

}
