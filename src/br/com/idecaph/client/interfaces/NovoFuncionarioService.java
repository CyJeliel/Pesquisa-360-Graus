package br.com.idecaph.client.interfaces;

import br.com.idecaph.shared.Funcionario;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("novoFuncionario")
public interface NovoFuncionarioService extends RemoteService{
	Boolean cadastraFuncionario(Funcionario funcionario);

	boolean atualizaFuncionario(Funcionario funcionario);
}
