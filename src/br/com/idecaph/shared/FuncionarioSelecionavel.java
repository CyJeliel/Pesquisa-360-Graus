package br.com.idecaph.shared;



public class FuncionarioSelecionavel extends Funcionario {
	boolean selecionado;
	private String porcentagem;

	public FuncionarioSelecionavel() {
		// TODO Auto-generated constructor stub
	}

	public FuncionarioSelecionavel(String nome, String identificacao,
			String cargo, String departamento, boolean selecionado) {
		super(nome, identificacao, cargo, departamento);
		this.selecionado = selecionado;
	}

	public FuncionarioSelecionavel(String nome, String identificacao,
			String cargo, String departamento, boolean selecionado,
			String porcentagem) {
		this(nome, identificacao, cargo, departamento, selecionado);
		this.porcentagem = porcentagem;
	}

	public FuncionarioSelecionavel(Funcionario funcionario) {
		super(funcionario.getNome(), funcionario.getIdentificacao(),
				funcionario.getCargo(), funcionario.getDepartamento());
	}

	public void seleciona() {
		this.selecionado = true;
	}

	public boolean isSelecionado() {
		return selecionado;
	}

	public String getPorcentagemRespondida() {
		return porcentagem;
	}
}
