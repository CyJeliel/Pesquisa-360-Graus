package br.com.idecaph.model;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import br.com.idecaph.shared.Funcionario;

@PersistenceCapable
public class Funcionarios extends Model<Funcionarios, Funcionario> {

	@PrimaryKey
	@Persistent
	private String identificacao;

	@Persistent
	private String nome;

	@Persistent
	private String cargo;

	@Persistent
	private String departamento;

	public Funcionarios(String identificacao, String cargo, String nome,
			String departamento) {
		this.identificacao = identificacao;
		this.cargo = cargo;
		this.nome = nome;
		this.departamento = departamento;
	}

	public String getCargo() {
		return cargo;
	}

	public String getNome() {
		return nome;
	}

	public String getDepartamento() {
		return departamento;
	}

	public String getIdentificacao() {
		return identificacao;
	}

	@Override
	public boolean update(Funcionario funcionario) {
		boolean retorno = true;
		try {
			Funcionarios funcionarioModel = pm.getObjectById(
					Funcionarios.class, funcionario.getIdentificacao());
			funcionarioModel.setNome(funcionario.getNome());
			funcionarioModel.setCargo(funcionario.getCargo());
			funcionarioModel.setDepartamento(funcionario.getDepartamento());
		} catch (Exception e) {
			retorno = false;
		} finally {
			pm.close();
		}

		return retorno;
	}

	private void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	private void setCargo(String cargo) {
		this.cargo = cargo;
	}

	private void setNome(String nome) {
		this.nome = nome;
	}
}
