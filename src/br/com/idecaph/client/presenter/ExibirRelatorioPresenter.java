package br.com.idecaph.client.presenter;

import br.com.idecaph.client.display.ExibirRelatorioDisplay;
import br.com.idecaph.shared.Funcionario;
import br.com.idecaph.shared.Pesquisa;

import com.google.gwt.event.shared.HandlerManager;

public class ExibirRelatorioPresenter extends Presenter<ExibirRelatorioDisplay> {

	private Funcionario funcionario;
	private Pesquisa pesquisa;
	private int perguntaAtual = 0;

	public ExibirRelatorioPresenter(ExibirRelatorioDisplay display,
			HandlerManager eventBus, Funcionario funcionario, Pesquisa pesquisa) {
		super(display, eventBus);
		this.funcionario = funcionario;
		this.pesquisa = pesquisa;
	}

	@Override
	public void bind() {
		final ExibirRelatorioDisplay display = super.getDisplay();
		display.getNomeFuncionario().setText(funcionario.getDisplayNome());
//		String pergunta = pesquisa.getPerguntas().get(perguntaAtual).getPergunta();
//		display.getLabelPergunta().setText(pergunta);
	}
}
