package br.com.idecaph.shared;

import br.com.idecaph.client.view.colunas.InformacaoTabela;

public class FuncionarioSelecionavel extends InformacaoTabela {
	boolean selecionado;
	private String porcentagem;
	private FuncionarioClient funcionario;
	private int porcentagemPerguntasRespondidas;

	public FuncionarioSelecionavel() {
	}

	public FuncionarioSelecionavel(Long id, String nome, String identificacao,
			String cargo, String departamento, boolean selecionado) {
		this.setFuncionario(new FuncionarioClient(id, nome, identificacao,
				cargo, departamento));
		this.selecionado = selecionado;
	}

	public FuncionarioSelecionavel(Long id, String nome, String identificacao,
			String cargo, String departamento, boolean selecionado,
			String porcentagem) {
		this(id, nome, identificacao, cargo, departamento, selecionado);
		this.porcentagem = porcentagem;
	}

	public FuncionarioSelecionavel(FuncionarioClient funcionario) {
		this.setFuncionario(funcionario);
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

	public void setPorcentagemPerguntasRespondidas(int porcentagemPerguntasRespondidas) {
		this.porcentagemPerguntasRespondidas = porcentagemPerguntasRespondidas;
	}

	public String getDisplayId() {
		return getFuncionario().getId() == null ? "" : getFuncionario().getId()
				.toString();
	}

	public String getDisplayNome() {
		return getFuncionario().getNome();
	}

	public String getDisplayIdentificacao() {
		return getFuncionario().getIdentificacao();
	}

	public String getDisplayCargo() {
		return getFuncionario().getCargo();
	}

	public String getDisplayDepartamento() {
		return getFuncionario().getDepartamento();
	}

	public Long getId() {
		return getFuncionario().getId();
	}

	public String getNome() {
		return getFuncionario().getNome();
	}

	public String getIdentificacao() {
		return getFuncionario().getIdentificacao();
	}

	public String getCargo() {
		return getFuncionario().getCargo();
	}

	public String getDepartamento() {
		return getFuncionario().getDepartamento();
	}

	public void setId(Long id) {
		this.getFuncionario().setId(id);
	}

	public void setNome(String nome) {
		this.getFuncionario().setNome(nome);
	}

	public void setIdentificacao(String identificacao) {
		this.getFuncionario().setIdentificacao(identificacao);
	}

	public void setCargo(String cargo) {
		this.getFuncionario().setCargo(cargo);
	}

	public void setDepartamento(String departamento) {
		this.getFuncionario().setDepartamento(departamento);
	}

	public FuncionarioClient getFuncionario() {
		return funcionario;
	}

	public int getPorcentagemPerguntasRespondidas() {
		return porcentagemPerguntasRespondidas;
	}

	public void setFuncionario(FuncionarioClient funcionario) {
		this.funcionario = funcionario;
	}
}
