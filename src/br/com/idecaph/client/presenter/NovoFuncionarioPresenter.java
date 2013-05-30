package br.com.idecaph.client.presenter;

import br.com.idecaph.client.display.NovoFuncionarioDisplay;
import br.com.idecaph.client.interfaces.NovoFuncionarioService;
import br.com.idecaph.client.interfaces.NovoFuncionarioServiceAsync;
import br.com.idecaph.client.utils.FuncionariosHelper;
import br.com.idecaph.shared.Funcionario;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.TextBox;

public class NovoFuncionarioPresenter extends Presenter<NovoFuncionarioDisplay> {
	private NovoFuncionarioServiceAsync rpcService = GWT
			.create(NovoFuncionarioService.class);
	private Funcionario funcionario;

	public NovoFuncionarioPresenter(NovoFuncionarioDisplay display,
			HandlerManager eventBus) {
		this(display, eventBus, null);
	}

	public NovoFuncionarioPresenter(NovoFuncionarioDisplay display,
			HandlerManager eventBus, Funcionario funcionario) {
		super(display, eventBus);
		this.funcionario = funcionario;
	}

	@Override
	public void bind() {
		final NovoFuncionarioDisplay display = super.getDisplay();
		display.getAcaoSalvar().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Funcionario novoFuncionario = display.getDadosNovoFuncionario();
				boolean valido = validaDadosFuncionario(novoFuncionario);
				if (valido) {
					if (funcionario != null) {
						cadastraFuncionario(novoFuncionario);
					} else {
						atualizaFuncionario(novoFuncionario);
					}
				}
			}
		});

		display.getAcaoCancelar().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				FuncionariosHelper helper = new FuncionariosHelper(eventBus,
						true);
				helper.getFuncionarios();
			}
		});

		if (funcionario != null) {
			String nome = funcionario.getNome();
			display.getNome().setText(nome);
			String identificacao = funcionario.getIdentificacao();
			TextBox boxIdentificacao = display.getIdentificacao();
			boxIdentificacao.setText(identificacao);
			boxIdentificacao.setEnabled(false);
			String cargo = funcionario.getCargo();
			display.getCargo().setText(cargo);
			String departamento = funcionario.getDepartamento();
			display.getDepartamento().setText(departamento);
		}

	}

	private boolean validaDadosFuncionario(Funcionario funcionario) {
		boolean valido = true;
		String nome = funcionario.getNome();
		String identificacao = funcionario.getIdentificacao();
		String cargo = funcionario.getCargo();
		String departamento = funcionario.getDepartamento();

		if (nome.isEmpty()) {
			exibeErro(NovoFuncionarioDisplay.NOME_FUNCIONARIO);
			valido = false;
		} else if (identificacao.isEmpty()) {
			exibeErro(NovoFuncionarioDisplay.IDENTIFICACAO_FUNCIONARIO);
			valido = false;
		} else if (cargo.isEmpty()) {
			exibeErro(NovoFuncionarioDisplay.CARGO_FUNCIONARIO);
			valido = false;
		} else if (departamento.isEmpty()) {
			exibeErro(NovoFuncionarioDisplay.DEPARTAMENTO_FUNCIONARIO);
			valido = false;
		}
		return valido;
	}

	private void cadastraFuncionario(Funcionario funcionario) {
		rpcService.cadastraFuncionario(funcionario,
				new AsyncCallback<Boolean>() {

					@Override
					public void onSuccess(Boolean result) {
						exibeFeedback(NovoFuncionarioDisplay.CADASTRO_FUNCIONARIO);
					}

					@Override
					public void onFailure(Throwable caught) {
						exibeFeedback(NovoFuncionarioDisplay.ERRO_CADASTRO_FUNCIONARIO);
					}
				});
	}

	private void atualizaFuncionario(Funcionario funcionario) {
		rpcService.atualizaFuncionario(funcionario,
				new AsyncCallback<Boolean>() {

					@Override
					public void onSuccess(Boolean result) {
						exibeFeedback(NovoFuncionarioDisplay.ATUALIZA_FUNCIONARIO);
					}

					@Override
					public void onFailure(Throwable caught) {
						exibeFeedback(NovoFuncionarioDisplay.ERRO_ATUALIZA_FUNCIONARIO);
					}
				});
	}

	private void exibeFeedback(int tipoFeedback) {
		super.getDisplay().exibeFeedback(tipoFeedback);
	}

	private void exibeErro(int tipoErro) {
		super.getDisplay().exibeErro(tipoErro);
	}

}
